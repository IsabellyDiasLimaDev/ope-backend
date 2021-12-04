package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Prestante;
import br.com.giorni.gerenciadororcamento.model.Usuario;
import br.com.giorni.gerenciadororcamento.repository.PrestanteRepository;
import br.com.giorni.gerenciadororcamento.repository.UsuarioRepository;
import br.com.giorni.gerenciadororcamento.service.dto.PrestanteDTO;
import br.com.giorni.gerenciadororcamento.service.dto.UsuarioDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.PrestanteMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> findAll(){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return usuarioList.stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> findById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            UsuarioDTO usuarioDTO = UsuarioMapper.toDto(usuario.get());
            return Optional.of(usuarioDTO);
        }
        return Optional.empty();
    }

    public Usuario update(UsuarioDTO usuarioDTO){
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public boolean delete(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
