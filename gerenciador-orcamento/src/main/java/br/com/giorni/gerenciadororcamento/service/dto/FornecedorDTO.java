package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
