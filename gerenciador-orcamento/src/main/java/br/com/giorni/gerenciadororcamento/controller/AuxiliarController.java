package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.service.AuxiliarService;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auxiliares")
public class AuxiliarController {

    @Autowired
    private AuxiliarService auxiliarService;

    @PostMapping
    public Auxiliar save(@RequestBody AuxiliarDTO auxiliarDTO) {
        return auxiliarService.save(auxiliarDTO);
    }

    @GetMapping
    public List<AuxiliarDTO> findAll() {
        return auxiliarService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return auxiliarService.findById(id)
                .map(servicoDTO -> ResponseEntity.ok().body(servicoDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public Auxiliar update(@RequestBody AuxiliarDTO auxiliarDTO) {
        return auxiliarService.update(auxiliarDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = auxiliarService.delete(id);
        return deletou ? ResponseEntity.ok().body("Auxiliar removido com sucesso") : ResponseEntity.notFound().build();

    }
}
