package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.MaterialRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.ServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material save(MaterialDTO materialDTO){
        Material material = MaterialMapper.INSTANCE.materialDtoToMaterial(materialDTO);
        return materialRepository.save(material);
    }

    public List findAllWithService(){
        List list = materialRepository.findAllWithService();
        return list;
    }

    public List<MaterialDTO> findAll(){
        List<Material> materials = materialRepository.findAll();
        return  materials.stream()
                .map(material -> MaterialMapper.INSTANCE.materialToMaterialDto(material))
                .collect(Collectors.toList());
    }


}
