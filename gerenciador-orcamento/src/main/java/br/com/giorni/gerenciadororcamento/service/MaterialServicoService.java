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

}
