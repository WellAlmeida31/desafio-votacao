package br.com.dbserver.assembleia.application.v1.usecase.dto;

import br.com.dbserver.assembleia.domain.assembleia.entity.Assembleia;
import br.com.dbserver.assembleia.domain.assembleia.entity.AssembleiaStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssembleiaResponseDto(Long id, String nome, AssembleiaStatus status,  @JsonProperty("Pautas") List<PautaResponseDto> pautaResponseDtoList) {
    public AssembleiaResponseDto(Assembleia assembleia, List<PautaResponseDto> pautaResponseDtoList) {
        this(assembleia.getId(), assembleia.getNome(), assembleia.getStatus(), pautaResponseDtoList);
    }
    public AssembleiaResponseDto(Assembleia assembleia) {
        this(assembleia.getId(), assembleia.getNome(), assembleia.getStatus(), null);
    }
}
