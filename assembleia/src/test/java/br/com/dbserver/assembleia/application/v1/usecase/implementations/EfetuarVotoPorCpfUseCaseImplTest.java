package br.com.dbserver.assembleia.application.v1.usecase.implementations;

import br.com.dbserver.assembleia.application.v1.kafka.Producer;
import br.com.dbserver.assembleia.application.v1.usecase.dto.VotoKafka;
import br.com.dbserver.assembleia.application.v1.usecase.dto.VotoRequestDto;
import br.com.dbserver.assembleia.domain.associado.entity.Associado;
import br.com.dbserver.assembleia.domain.associado.entity.AssociadoStatus;
import br.com.dbserver.assembleia.domain.pauta.entity.Pauta;
import br.com.dbserver.assembleia.domain.pauta.entity.PautaStatus;
import br.com.dbserver.assembleia.domain.voto.entity.VotoValor;
import br.com.dbserver.assembleia.infrastructure.persistence.AssociadoRepository;
import br.com.dbserver.assembleia.infrastructure.persistence.PautaRepository;
import br.com.dbserver.assembleia.infrastructure.persistence.VotoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@DisplayName("EfetuarVotoPorCpfUseCaseImpl Test")
class EfetuarVotoPorCpfUseCaseImplTest {

    @Mock
    private Producer producer;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private PautaRepository pautaRepository;

    @Mock
    private VotoRepository votoRepository;

    @InjectMocks
    private EfetuarVotoPorCpfUseCaseImpl useCase;
    @InjectMocks
    EfetuarVotoPorCpfUseCaseImpl.ValidarAssociadoHabilEPautaIniciada validarAssociadoHabilEPautaIniciada;
    @InjectMocks
    EfetuarVotoPorCpfUseCaseImpl.ValidarSeAssociadoJaVotou validarSeAssociadoJaVotou;
    @Mock
    private List<EfetuarVotoPorCpfUseCaseImpl.ValidarVoto> validarVoto = new ArrayList<>();
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        validarVoto.add(validarSeAssociadoJaVotou);
        validarVoto.add(validarAssociadoHabilEPautaIniciada);
    }

    @Test
    public void testPersistirVoto_ValidacaoPassou() {
        VotoRequestDto requestDto = new VotoRequestDto(VotoValor.SIM, "12345678900", 1L);

        VotoKafka votoKafka = VotoKafka.builder().voto(requestDto).build();

        Associado associado = new Associado();
        associado.setId(1L);
        associado.setCpf("12345678900");
        associado.setNome("Associado Teste");
        associado.setStatus(AssociadoStatus.ABLE_TO_VOTE);

        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setDescricao("Descrição da Pauta");
        pauta.setStatus(PautaStatus.INICIADA);

        when(associadoRepository.findByCpf(anyString())).thenReturn(Optional.of(associado));
        when(pautaRepository.findById(anyLong())).thenReturn(Optional.of(pauta));
        when(votoRepository.existsByAssociadosAndPautas(anyList(), anyList())).thenReturn(false);

        useCase.persistirVoto(votoKafka);

        verify(associadoRepository, times(1)).findByCpf(anyString());
        verify(pautaRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testPersistirVoto_ValidacaoNaoPassou() {
        VotoRequestDto requestDto = new VotoRequestDto(VotoValor.SIM, "12345678900", 1L);

        VotoKafka votoKafka = VotoKafka.builder().voto(requestDto).build();

        Associado associado = new Associado();
        associado.setId(1L);
        associado.setCpf("12345678900");
        associado.setNome("Associado Teste");
        associado.setStatus(AssociadoStatus.UNABLE_TO_VOTE);

        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setDescricao("Descrição da Pauta");
        pauta.setStatus(PautaStatus.FINALIZADA);

        when(associadoRepository.findByCpf(anyString())).thenReturn(Optional.of(associado));
        when(pautaRepository.findById(anyLong())).thenReturn(Optional.of(pauta));
        when(votoRepository.existsByAssociadosAndPautas(anyList(), anyList())).thenReturn(true);

        useCase.persistirVoto(votoKafka);

        verifyNoInteractions(producer);
        verify(associadoRepository, times(1)).findByCpf(anyString());
        verify(pautaRepository, times(1)).findById(anyLong());
    }

}