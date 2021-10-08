package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class ClienteDTO {
    private Long id;
    private String tipoCliente;
    private String email;
    private String nome;
    private EnderecoDTO endereco;
    private String cpfCnpj;
    private String telefone;
}
