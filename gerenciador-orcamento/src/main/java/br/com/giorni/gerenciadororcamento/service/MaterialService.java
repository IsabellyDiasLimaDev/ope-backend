package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.repository.FornecedorRepository;
import br.com.giorni.gerenciadororcamento.repository.MaterialRepository;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.FornecedorMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorSemMaterialResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Boolean save(MaterialDTO materialDTO) {
        Material material = MaterialMapper.toEntity(materialDTO);
        material = materialRepository.save(material);
        for (Fornecedor fornecedor :
                material.getFornecedores()) {
            fornecedor.adicionarMaterial(material);
            fornecedorRepository.save(fornecedor);
        }
        return true;
    }


    public List<MaterialResponse> findAll() {
        List<Material> materiais = materialRepository.findAll();
        List<MaterialResponse> materialResponse = new ArrayList<>();
        materiais.forEach(material -> {
            if (material.getFornecedores().size() > 0) {
                List<FornecedorSemMaterialResponse> fornecedorSemMaterialResponseList = new ArrayList<>();
                material.getFornecedores().forEach(fornecedor -> fornecedorSemMaterialResponseList.add(FornecedorMapper.toResponseSemMaterial(fornecedor)));
                materialResponse.add(MaterialMapper.toResponse(material, fornecedorSemMaterialResponseList));
            } else {
                materialResponse.add(MaterialMapper.toResponse(material, new ArrayList<>()));
            }
        });
        return materialResponse;
    }

    public Optional<MaterialResponse> findById(Long id) {
        Optional<Material> materialOptional = materialRepository.findById(id);
        List<FornecedorSemMaterialResponse> fornecedores = new ArrayList<>();
        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            if (material.getFornecedores().size() > 0) {
                material.getFornecedores().forEach(fornecedor -> fornecedores.add(FornecedorMapper.toResponseSemMaterial(fornecedor)));
            }
            MaterialResponse materialResponse = MaterialMapper.toResponse(material, fornecedores);
            return Optional.of(materialResponse);
        }
        return Optional.empty();
    }

    public MaterialResponse update(MaterialDTO materialDTO) {
        Material material = MaterialMapper.toEntity(materialDTO);
        material = materialRepository.save(material);
        List<FornecedorSemMaterialResponse> fornecedorSemMaterialResponseList = new ArrayList<>();
        if (material.getFornecedores().size() > 0) {
            material.getFornecedores().forEach(fornecedor -> fornecedorSemMaterialResponseList.add(FornecedorMapper.toResponseSemMaterial(fornecedor)));

        }
        return MaterialMapper.toResponse(material, fornecedorSemMaterialResponseList);
    }

    public boolean delete(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        if (material.isPresent()) {
            materialRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
