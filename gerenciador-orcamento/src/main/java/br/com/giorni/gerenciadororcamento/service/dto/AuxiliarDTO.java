package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.Column;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class AuxiliarDTO {
    private Long id;
    private String telefone;
    private String nome;
    private String tipoServico;
    private boolean disponbibilidade;
    private String email;
}
