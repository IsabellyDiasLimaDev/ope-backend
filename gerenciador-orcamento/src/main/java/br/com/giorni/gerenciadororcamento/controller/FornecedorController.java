package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.service.FornecedorService;
import br.com.giorni.gerenciadororcamento.service.dto.FornecedorDTO;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public Fornecedor save(@RequestBody FornecedorDTO fornecedorDTO) {
        return fornecedorService.save(fornecedorDTO);
    }

    @GetMapping
    public List<FornecedorResponse> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return fornecedorService.findById(id)
                .map(servicoDTO -> ResponseEntity.ok().body(servicoDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public FornecedorResponse update(@RequestBody FornecedorDTO fornecedorDTO) {
        return fornecedorService.update(fornecedorDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = fornecedorService.delete(id);
        return deletou ? ResponseEntity.ok().body("Fornecedor removido com sucesso") : ResponseEntity.notFound().build();

    }
}
