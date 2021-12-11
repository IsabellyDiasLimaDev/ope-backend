package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Cliente;
import br.com.giorni.gerenciadororcamento.service.ClienteService;
import br.com.giorni.gerenciadororcamento.service.dto.ClienteDTO;
import br.com.giorni.gerenciadororcamento.service.response.ClienteSemOrcamentoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente save(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }

    @GetMapping
    public List<ClienteSemOrcamentoResponse> findAll() {
        return clienteService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(clienteDTO -> ResponseEntity.ok().body(clienteDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public Cliente update(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.update(clienteDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = clienteService.delete(id);
        return deletou ? ResponseEntity.ok().body("Cliente removido com sucesso") : ResponseEntity.notFound().build();

    }
}
