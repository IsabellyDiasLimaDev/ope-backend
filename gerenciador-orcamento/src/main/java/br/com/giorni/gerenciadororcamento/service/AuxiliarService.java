package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.repository.AuxiliarRepository;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuxiliarService {

    @Autowired
    private AuxiliarRepository auxiliarRepository;

    public Auxiliar save(AuxiliarDTO auxiliarDTO) {
        Auxiliar auxiliar = AuxiliarMapper.toEntity(auxiliarDTO);
        return auxiliarRepository.save(auxiliar);
    }

    public List<AuxiliarDTO> findAll(){
        List<Auxiliar> auxiliarList = auxiliarRepository.findAll();
        return auxiliarList.stream()
                .map(AuxiliarMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<AuxiliarDTO> findById(Long id){
        Optional<Auxiliar> auxiliar = auxiliarRepository.findById(id);
        if (auxiliar.isPresent()){
            AuxiliarDTO auxiliarDTO = AuxiliarMapper.toDto(auxiliar.get());
            return Optional.of(auxiliarDTO);
        }
        return Optional.empty();
    }

    public Auxiliar update(AuxiliarDTO auxiliarDTO){
        Auxiliar auxiliar = AuxiliarMapper.toEntity(auxiliarDTO);
        return auxiliarRepository.save(auxiliar);
    }

    public boolean delete(Long id) {
        Optional<Auxiliar> auxiliar = auxiliarRepository.findById(id);
        if (auxiliar.isPresent()) {
            auxiliarRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
