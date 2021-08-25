package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.service.MaterialService;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
