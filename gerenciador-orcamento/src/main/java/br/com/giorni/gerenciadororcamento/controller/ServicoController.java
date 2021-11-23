package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.service.ServicoService;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public MaterialServico createServiceWithMaterial(@RequestBody MaterialServicoDTO materialServicoDTO){
        return servicoService.save(materialServicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        return ResponseEntity.ok().body(servicoService.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return servicoService.findById(id)
                .map(servicoDTO -> ResponseEntity.ok().body(servicoDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ServicoDTO servicoDTO){
        return servicoService.update(servicoDTO)
                .map(servico -> ResponseEntity.ok().body(servico))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        boolean deletou = servicoService.delete(id);
        return deletou == true ? ResponseEntity.ok().body("Serviço removido com sucesso") : ResponseEntity.notFound().build();
    }
}