package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Usuario;
import br.com.giorni.gerenciadororcamento.service.UsuarioService;
import br.com.giorni.gerenciadororcamento.service.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(usuarioDTO -> ResponseEntity.ok().body(usuarioDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    //TODO Resolver problema ao editar um Usuário
    @PutMapping
    public Usuario update(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(usuarioDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = usuarioService.delete(id);
        return deletou ? ResponseEntity.ok().body("Usuario removido com sucesso") : ResponseEntity.notFound().build();

    }
}
