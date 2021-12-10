package br.com.giorni.gerenciadororcamento.controller;

import br.com.giorni.gerenciadororcamento.model.Orcamento;
import br.com.giorni.gerenciadororcamento.service.OrcamentoService;
import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import br.com.giorni.gerenciadororcamento.service.response.OrcamentoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @PostMapping
    public boolean save(@RequestBody OrcamentoDTO orcamentoDTO) {
        return orcamentoService.save(orcamentoDTO);
    }

    @GetMapping
    public List<OrcamentoResponse> findAll() {
        return orcamentoService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return orcamentoService.findById(id)
                .map(servicoDTO -> ResponseEntity.ok().body(servicoDTO))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public OrcamentoResponse update(@RequestBody OrcamentoDTO orcamentoDTO) {
        return orcamentoService.update(orcamentoDTO);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletou = orcamentoService.delete(id);
        return deletou ? ResponseEntity.ok().body("Orcamento removido com sucesso") : ResponseEntity.notFound().build();
    }

}
