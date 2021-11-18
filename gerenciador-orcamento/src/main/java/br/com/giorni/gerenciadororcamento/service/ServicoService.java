package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.OrcamentoRepository;
import br.com.giorni.gerenciadororcamento.repository.ServicoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoSemMaterialDTO;
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
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialServicoService materialServicoService;

    public MaterialServico save(MaterialServicoDTO materialServicoDTO ) {
        var servico = materialServicoDTO.getServico().toEntity();
        var material = materialServicoDTO.getMaterial().toEntity();
        servico = servicoRepository.save(servico);
        return materialServicoService.save(new MaterialServico(materialServicoDTO.getQuantidadeMaterial(), material, servico));
    }

    public List<ServicoDTO> findAll() {
        List<Servico> servicos = servicoRepository.findAll();
        return servicos.stream()
                .map(Servico::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ServicoDTO> findById(Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico.map(ServicoMapper.INSTANCE::servicoToServicoDto);
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
