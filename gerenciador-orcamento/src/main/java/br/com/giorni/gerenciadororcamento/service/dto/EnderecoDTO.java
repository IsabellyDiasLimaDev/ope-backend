package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class EnderecoDTO {
    Long id;
    String numero;
    String cep;
    String cidade;
    String bairro;
    String logradouro;
    String estado;
}
