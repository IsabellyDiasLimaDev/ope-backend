//package br.com.giorni.gerenciadororcamento.controller;
//
//import br.com.giorni.gerenciadororcamento.service.UsuarioService;
//import br.com.giorni.gerenciadororcamento.service.dto.UsuarioDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/usuarios")
//public class UsuarioController {
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @GetMapping
//    public ResponseEntity<List<UsuarioDTO>> findAll() {
//        List<UsuarioDTO> usuarios = usuarioService.findAll();
//       // log.info("usuarios {}", usuarios);
//        return ResponseEntity.ok(usuarios);
//    }
//}
