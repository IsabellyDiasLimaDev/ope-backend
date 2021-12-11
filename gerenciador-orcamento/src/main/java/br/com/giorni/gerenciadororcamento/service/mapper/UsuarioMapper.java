package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Usuario;
import br.com.giorni.gerenciadororcamento.service.dto.UsuarioDTO;
import br.com.giorni.gerenciadororcamento.service.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static Usuario toEntity(UsuarioDTO usuarioDTO){
        return Usuario
                .builder()
                .id(usuarioDTO.getId())
                .login(usuarioDTO.getLogin())
                .senha(usuarioDTO.getSenha())
                .build();
    }

    public static UsuarioDTO toDto(Usuario usuario){

        return UsuarioDTO
                .builder()
                .id(usuario.getId())
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .build();
    }

    public static UsuarioResponse toResponse(Usuario usuario) {

        return UsuarioResponse.builder()
                .id(usuario.getId())
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .build();

    }

}
