package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.service.MaterialService;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    public MaterialController(MaterialService materialService){
        this.materialService = materialService;
    }

    @PostMapping
    public Material create(@RequestBody MaterialDTO materialDTO){
        return materialService.save(materialDTO);
    }

    @GetMapping(path = "/with-service")
    public ResponseEntity<?> findAllWithService(){
        return ResponseEntity.ok().body(materialService.findAllWithService());
    }

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> findAll(){
        return ResponseEntity.ok().body(materialService.findAll());
    }
}
