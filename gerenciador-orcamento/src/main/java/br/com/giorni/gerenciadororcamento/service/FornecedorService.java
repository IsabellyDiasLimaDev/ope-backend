package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.repository.AuxiliarRepository;
import br.com.giorni.gerenciadororcamento.repository.FornecedorRepository;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.FornecedorDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.FornecedorMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorResponse;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorSemMaterialResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialSemFornecedorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor save(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = FornecedorMapper.toEntity(fornecedorDTO);
        return fornecedorRepository.save(fornecedor);
    }

    public List<FornecedorResponse> findAll(){
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        List<FornecedorResponse> fornecedorResponse = new ArrayList<>();
        fornecedores.forEach(fornecedor -> {
            if (fornecedor.getMateriais().size() > 0){
                List<MaterialSemFornecedorResponse> materialSemFornecedorResponseList = new ArrayList<>();
                fornecedor.getMateriais().forEach(material -> materialSemFornecedorResponseList.add(MaterialMapper.toResponseSemFornecedor(material)));
                fornecedorResponse.add(FornecedorMapper.toResponse(fornecedor, materialSemFornecedorResponseList));
            }
            else
            {
                fornecedorResponse.add(FornecedorMapper.toResponse(fornecedor, new ArrayList<>()));
            }
        });
        return fornecedorResponse;
    }

    public Optional<FornecedorResponse> findById(Long id){
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);
        List<MaterialSemFornecedorResponse> materiais = new ArrayList<>();
        if (fornecedorOptional.isPresent()){
            Fornecedor fornecedor = fornecedorOptional.get();
            if (fornecedor.getMateriais().size() > 0){
                fornecedor.getMateriais().forEach(material -> materiais.add(MaterialMapper.toResponseSemFornecedor(material)));
            }
            FornecedorResponse fornecedorResponse = FornecedorMapper.toResponse(fornecedor, materiais);
            return Optional.of(fornecedorResponse);
        }
        return Optional.empty();
    }

    public FornecedorResponse update(FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = FornecedorMapper.toEntity(fornecedorDTO);
        fornecedor = fornecedorRepository.save(fornecedor);
        FornecedorResponse fornecedorResponse = new FornecedorResponse();
            if (fornecedor.getMateriais().size() > 0){
                List<MaterialSemFornecedorResponse> materialSemFornecedorResponseList = new ArrayList<>();
                fornecedor.getMateriais().forEach(material -> materialSemFornecedorResponseList.add(MaterialMapper.toResponseSemFornecedor(material)));
                fornecedorResponse = FornecedorMapper.toResponse(fornecedor, materialSemFornecedorResponseList);
            }
            else
            {
                fornecedorResponse = FornecedorMapper.toResponse(fornecedor, new ArrayList<>());
            }
        return fornecedorResponse;
    }

    public boolean delete(Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if (fornecedor.isPresent()) {
            fornecedorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
