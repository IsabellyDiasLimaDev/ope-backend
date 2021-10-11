package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.OrcamentoRepository;
import br.com.giorni.gerenciadororcamento.repository.ServicoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoSemMaterialDTO;
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
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private MaterialService materialService;

    public Servico save(ServicoDTO servicoDTO ) {
        var servico = ServicoMapper.INSTANCE.servicoDtoToServico(servicoDTO);
        return servicoRepository.save(servico);
    }

    public List<ServicoDTO> findAll() {
        List<Servico> servicos = servicoRepository.findAll();
        return servicos.stream()
                .map(servico -> ServicoMapper.INSTANCE.servicoToServicoDto(servico))
                .collect(Collectors.toList());
    }

    public Optional<ServicoDTO> findById(Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()) {
            return Optional.of(ServicoMapper.INSTANCE.servicoToServicoDto(servico.get()));
        }
        return Optional.empty();
    }

    public Optional<ServicoDTO> update(ServicoDTO servicoDTO) {
        return servicoRepository.findById(servicoDTO.getId()).map(s -> {
            var substituto = ServicoMapper.INSTANCE.servicoDtoToServico(servicoDTO);
            Servico updated = servicoRepository.save(substituto);
            return updated.toDto();
        });
    }

    public boolean delete(Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()) {
            servicoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
