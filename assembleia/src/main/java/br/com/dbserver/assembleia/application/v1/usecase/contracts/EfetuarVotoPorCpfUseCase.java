package br.com.dbserver.assembleia.application.v1.usecase.contracts;

import br.com.dbserver.assembleia.application.v1.usecase.dto.VotoKafka;
import br.com.dbserver.assembleia.application.v1.usecase.dto.VotoRequestDto;

public interface EfetuarVotoPorCpfUseCase {
    void efetuarVoto(VotoRequestDto dto);
    void persistirVoto(VotoKafka votoKafka);

}
