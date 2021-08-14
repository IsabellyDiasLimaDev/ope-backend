package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Usuario;
import br.com.giorni.gerenciadororcamento.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioToUsuarioDto(Usuario usuario);
}
