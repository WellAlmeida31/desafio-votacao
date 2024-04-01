package br.com.dbserver.assembleia.application.v1.usecase.dto;

import jakarta.validation.constraints.NotEmpty;

public record AssembleiaRequestDto(@NotEmpty String nome) {
}
