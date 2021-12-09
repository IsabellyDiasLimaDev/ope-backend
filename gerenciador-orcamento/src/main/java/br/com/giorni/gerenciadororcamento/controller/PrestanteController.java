package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Prestante;
import br.com.giorni.gerenciadororcamento.service.PrestanteService;
import br.com.giorni.gerenciadororcamento.service.dto.PrestanteDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/prestantes")
public class PrestanteController {

    @Autowired
    private PrestanteService prestanteService;

    //TODO Ajustar métodos de CRUD do Prestante

    @PostMapping
    public Prestante save(@RequestBody PrestanteDTO prestanteDTO) {
        return prestanteService.save(prestanteDTO);
    }

    @GetMapping
    public List<PrestanteDTO> findAll() {
        return prestanteService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return prestanteService.findById(id)
                .map(prestanteDTO -> ResponseEntity.ok().body(prestanteDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public Prestante update(@RequestBody PrestanteDTO prestanteDTO) {
        return prestanteService.update(prestanteDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = prestanteService.delete(id);
        return deletou ? ResponseEntity.ok().body("Prestante removido com sucesso") : ResponseEntity.notFound().build();

    }
}
