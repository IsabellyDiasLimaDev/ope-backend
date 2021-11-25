package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class ClienteDTO {
    Long id;
    String tipoCliente;
    String email;
    String nome;
    EnderecoDTO endereco;
    List<OrcamentoDTO> orcamentos;
    String cpfCnpj;
    String telefone;

}
