package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.OrcamentoRepository;
import br.com.giorni.gerenciadororcamento.repository.ServicoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialServicoMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.ServicoMapper;
import br.com.giorni.gerenciadororcamento.service.response.AuxiliarSemServicoResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialSemFornecedorResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialServicoSemServicoResponse;
import br.com.giorni.gerenciadororcamento.service.response.ServicoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public MaterialServico save(MaterialServicoDTO materialServicoDTO) {
        var servico = ServicoMapper.toEntity(materialServicoDTO.getServico());
        var material = MaterialMapper.toEntity(materialServicoDTO.getMaterial());
        servico = servicoRepository.save(servico);
        return materialServicoService.save(new MaterialServico(materialServicoDTO.getQuantidadeMaterial(), material, servico));
    }

    public List<ServicoResponse> findAll() {
        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoResponse> servicoResponse = new ArrayList<>();
        List<MaterialServicoSemServicoResponse> materiais = new ArrayList<>();
        List<AuxiliarSemServicoResponse> auxiliares = new ArrayList<>();
        servicos.forEach(servico -> {
            if (servico.getMateriais().size() > 0) {
                servico.getMateriais().forEach(materialServico -> materiais.add(MaterialServicoMapper.toResponse(materialServico)));
            }
            if (servico.getAuxiliares().size() > 0){
                servico.getAuxiliares().forEach(auxiliar -> auxiliares.add(AuxiliarMapper.toResponseSemServico(auxiliar)));
            }
            servicoResponse.add(ServicoMapper.toResponse(servico, materiais, auxiliares));
        });
        return servicoResponse;
    }

    public Optional<ServicoResponse> findById(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);
        List<MaterialServicoSemServicoResponse> materiais = new ArrayList<>();
        List<AuxiliarSemServicoResponse> auxiliares = new ArrayList<>();
        if (servicoOptional.isPresent()) {
            Servico servico = servicoOptional.get();
            if (servico.getMateriais().size() > 0) {
                servico.getMateriais().forEach(materialServico -> materiais.add(MaterialServicoMapper.toResponse(materialServico)));
            }
            if (servico.getAuxiliares().size() > 0){
                servico.getAuxiliares().forEach(auxiliar -> auxiliares.add(AuxiliarMapper.toResponseSemServico(auxiliar)));
            }
            return Optional.of(ServicoMapper.toResponse(servico, materiais, auxiliares));
        }
        return Optional.empty();
    }

//    public MaterialServicoResponse update(MaterialServicoDTO materialServicoDTO) {
//
//    }

    public boolean delete(Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()) {
            servicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
