package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Usuario;
import br.com.giorni.gerenciadororcamento.repository.UsuarioRepository;
import br.com.giorni.gerenciadororcamento.service.dto.UsuarioDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


     public List<UsuarioDTO> findAll(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario))
                .collect(Collectors.toList());
    }

}
