package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Empresa;
import br.com.giorni.gerenciadororcamento.service.EmpresaService;
import br.com.giorni.gerenciadororcamento.service.dto.EmpresaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    //TODO Ajustar métodos de CRUD da Empresa

    @PostMapping
    public Empresa save(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.save(empresaDTO);
    }

    @GetMapping
    public List<EmpresaDTO> findAll() {
        return empresaService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return empresaService.findById(id)
                .map(empresaDTO -> ResponseEntity.ok().body(empresaDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public Empresa update(@RequestBody EmpresaDTO empresaDTO) {
        return empresaService.update(empresaDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = empresaService.delete(id);
        return deletou ? ResponseEntity.ok().body("Empresa removida com sucesso") : ResponseEntity.notFound().build();

    }
}
