package br.com.giorni.gerenciadororcamento.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class UsuarioDTO {

    Long id;
    String login;
    String senha;
}
