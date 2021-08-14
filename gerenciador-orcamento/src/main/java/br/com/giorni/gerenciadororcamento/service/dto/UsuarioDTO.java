package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Builder
public class UsuarioDTO {

    private Long id;
    private String login;
    private String email;
    private String senha;

}
