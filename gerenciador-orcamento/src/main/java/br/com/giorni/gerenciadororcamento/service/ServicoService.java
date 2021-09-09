package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.ServicoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.ServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private MaterialService materialService;

    public Servico save(ServicoDTO servicoDTO){
        Servico servico = ServicoMapper.INSTANCE.servicoDtoToServico(servicoDTO);
        servico.getMateriais().forEach(material -> {
            material.adicionarServico(servico);
            MaterialDTO materialDTO = MaterialMapper.INSTANCE.materialToMaterialDto(material);
            materialService.update(material.getId(),materialDTO);
        });
        return servicoRepository.save(servico);
    }

    public List<ServicoDTO> findAll(){
        List<Servico> servicos = servicoRepository.findAll();
        return  servicos.stream()
                .map(servico -> ServicoMapper.INSTANCE.servicoToServicoDto(servico))
                .collect(Collectors.toList());
    }

    public Optional<ServicoDTO> findById(Long id){
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()){
            return Optional.of(ServicoMapper.INSTANCE.servicoToServicoDto(servico.get()));
        }
        return Optional.empty();
    }

    public Optional<ServicoDTO> update(Long id, ServicoDTO servicoDTO){
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()){
            servico.get().setDescricao(servicoDTO.getDescricao());
            servico.get().setAuxiliares(servicoDTO.getAuxiliares());
            servico.get().setOrcamentos(servicoDTO.getOrcamentos());
            servico.get().setValorMaoDeObra(servicoDTO.getValorMaoDeObra());
            servico.get().setValorTotal(servicoDTO.getValorTotal());
            servico.get().setDtInicial(servicoDTO.getDtInicial());
            servico.get().setDtFinal(servicoDTO.getDtFinal());
            Servico updated = servicoRepository.save(servico.get());
            return Optional.of(ServicoMapper.INSTANCE.servicoToServicoDto(servico.get()));
        }
        return Optional.empty();
    }

    public Boolean delete(Long id){
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()){
            servicoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
