package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.MaterialServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServicoService {

    @Autowired
    private MaterialServicoRepository materialServicoRepository;

    public MaterialServico save(MaterialServico materialServico){
        materialServico = materialServicoRepository.save(materialServico);
        return materialServico;
    }

    public Servico calcularValorTotalServico(Servico servico){
        List<Double> valorTotalMateriaisList = new ArrayList<>();
        var valorTotalMateriais = 0.0;
        servico.getMateriais().forEach(materialServico -> {
            var valorTotalMaterial = materialServico.getMaterial().getPreco() * materialServico.getQuantidadeMaterial();
            valorTotalMateriaisList.add(valorTotalMaterial);
        });
        for (Double valor : valorTotalMateriaisList) {
            valorTotalMateriais += valor;
        }
        var valorTotalServico = valorTotalMateriais + servico.getValorMaoDeObra();
        servico.setValorTotal(valorTotalServico);
        return servico;
    }

}
