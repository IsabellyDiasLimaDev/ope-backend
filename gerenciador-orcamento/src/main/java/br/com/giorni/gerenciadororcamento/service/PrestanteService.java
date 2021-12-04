package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Prestante;
import br.com.giorni.gerenciadororcamento.repository.PrestanteRepository;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.PrestanteDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.PrestanteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestanteService {

    @Autowired
    private PrestanteRepository prestanteRepository;

    //TODO Ajustar métodos de CRUD do Prestante

    public Prestante save(PrestanteDTO prestanteDTO) {
        Prestante prestante = PrestanteMapper.toEntity(prestanteDTO);
        return prestanteRepository.save(prestante);
    }

    public List<PrestanteDTO> findAll(){
        List<Prestante> prestanteList = prestanteRepository.findAll();
        return prestanteList.stream()
                .map(PrestanteMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PrestanteDTO> findById(Long id){
        Optional<Prestante> prestante = prestanteRepository.findById(id);
        if (prestante.isPresent()){
            PrestanteDTO prestanteDTO = PrestanteMapper.toDto(prestante.get());
            return Optional.of(prestanteDTO);
        }
        return Optional.empty();
    }

    public Prestante update(PrestanteDTO prestanteDTO){
        Prestante prestante = PrestanteMapper.toEntity(prestanteDTO);
        return prestanteRepository.save(prestante);
    }

    public boolean delete(Long id) {
        Optional<Prestante> prestante = prestanteRepository.findById(id);
        if (prestante.isPresent()) {
            prestanteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
