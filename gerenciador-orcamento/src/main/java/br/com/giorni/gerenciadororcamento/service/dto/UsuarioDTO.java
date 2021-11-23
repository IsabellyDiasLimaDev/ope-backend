package br.com.giorni.gerenciadororcamento.service.dto;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class UsuarioDTO {

    private Long id;
    private String login;
    private String email;
    private String senha;
}
