package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.repository.MaterialRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material save(MaterialDTO materialDTO){
        Material material = MaterialMapper.INSTANCE.materialDtoToMaterial(materialDTO);
        return materialRepository.save(material);
    }
}
