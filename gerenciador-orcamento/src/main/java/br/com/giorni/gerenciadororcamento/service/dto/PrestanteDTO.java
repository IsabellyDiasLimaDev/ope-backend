package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class PrestanteDTO {

    Long id;
    UsuarioDTO login;
    String nome;
    EmpresaDTO empresa;
    String telefone;
    String email;

}
