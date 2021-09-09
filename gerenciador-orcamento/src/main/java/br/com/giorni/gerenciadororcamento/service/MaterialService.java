package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.repository.MaterialRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<MaterialDTO> update(Long id, MaterialDTO materialDTO){
        Optional<Material> material = materialRepository.findById(id);
        if (material.isPresent()){
            material.get().setPreco(materialDTO.getPreco());
            material.get().setTipo(materialDTO.getTipo());
            material.get().setCategoria(materialDTO.getCategoria());
            material.get().setQuantidadeDisponivel(materialDTO.getQuantidadeDisponivel());
            material.get().setQuantidadeDisponivel(materialDTO.getQuantidadeDisponivel());
            material.get().setDescricao(materialDTO.getDescricao());
            material.get().setCor(materialDTO.getCor());
            Material updated = materialRepository.save(material.get());
            return Optional.of(MaterialMapper.INSTANCE.materialToMaterialDto(material.get()));
        }
        return Optional.empty();
    }


}
