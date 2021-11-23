package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class PrestanteDTO {

    private Long id;
    private Long login;
    private String nome;
    private String telefone;

}
