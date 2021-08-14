package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Builder
public class PrestanteDTO {

    private Long id;
    private Long login;
    private String nome;
    private String telefone;

}
