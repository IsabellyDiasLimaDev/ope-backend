package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Empresa;
import br.com.giorni.gerenciadororcamento.repository.EmpresaRepository;
import br.com.giorni.gerenciadororcamento.repository.EnderecoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.EmpresaDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.EmpresaMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.EnderecoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    public Empresa save(EmpresaDTO empresaDTO) {
        Empresa empresa = EmpresaMapper.toEntity(empresaDTO);
        return empresaRepository.save(empresa);
    }

    public List<EmpresaDTO> findAll(){
        List<Empresa> empresaList = empresaRepository.findAll();
        return empresaList.stream()
                .map(EmpresaMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<EmpresaDTO> findById(Long id){
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()){
            EmpresaDTO empresaDTO = EmpresaMapper.toDto(empresa.get());
            return Optional.of(empresaDTO);
        }
        return Optional.empty();
    }

    public Empresa update(EmpresaDTO empresaDTO){
        Empresa empresa = EmpresaMapper.toEntity(empresaDTO);
        return empresaRepository.save(empresa);
    }

    public boolean delete(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            empresaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
