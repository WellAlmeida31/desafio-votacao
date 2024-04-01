package br.com.dbserver.assembleia.application.v1.usecase.contracts;


import java.io.ByteArrayInputStream;

public interface GerarRelatorioPdfDeVotosPorIdUseCase {
    ByteArrayInputStream RelatorioPdfDeVotos(Long id) throws java.io.IOException;
}
