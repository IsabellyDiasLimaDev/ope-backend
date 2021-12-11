package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Endereco;
import br.com.giorni.gerenciadororcamento.model.Endereco;
import br.com.giorni.gerenciadororcamento.repository.EnderecoRepository;
import br.com.giorni.gerenciadororcamento.repository.EnderecoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.EnderecoMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.EnderecoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(EnderecoDTO enderecoDTO) {
        Endereco endereco = EnderecoMapper.toEntity(enderecoDTO);
        return enderecoRepository.save(endereco);
    }

    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecoList = enderecoRepository.findAll();
        return enderecoList.stream()
                .map(EnderecoMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<EnderecoDTO> findById(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()){
            EnderecoDTO enderecoDTO = EnderecoMapper.toDto(endereco.get());
            return Optional.of(enderecoDTO);
        }
        return Optional.empty();
    }

    public Endereco update(EnderecoDTO enderecoDTO){
        Endereco endereco = EnderecoMapper.toEntity(enderecoDTO);
        return enderecoRepository.save(endereco);
    }

    public boolean delete(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
