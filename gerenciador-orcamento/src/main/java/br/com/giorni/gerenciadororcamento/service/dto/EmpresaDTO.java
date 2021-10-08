package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class EmpresaDTO {
    private Long id;
    private String nomeFantasia;
    private EnderecoDTO endereco;
}
