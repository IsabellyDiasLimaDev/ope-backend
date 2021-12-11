package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.service.MaterialService;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.response.MaterialResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    @PostMapping
    public Boolean create(@RequestBody MaterialDTO materialDTO){
        return materialService.save(materialDTO);
    }

    @GetMapping
    public ResponseEntity<List<MaterialResponse>> findAll(){
        return ResponseEntity.ok().body(materialService.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return materialService.findById(id)
                .map(materialDTO -> ResponseEntity.ok().body(materialDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public MaterialResponse update(@RequestBody MaterialDTO auxiliarDTO) {
        return materialService.update(auxiliarDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = materialService.delete(id);
        return deletou ? ResponseEntity.ok().body("Material removido com sucesso") : ResponseEntity.notFound().build();

    }
}
