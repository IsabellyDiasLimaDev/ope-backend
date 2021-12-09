package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Orcamento;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.OrcamentoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialServicoMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.OrcamentoMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.ServicoMapper;
import br.com.giorni.gerenciadororcamento.service.response.AuxiliarSemServicoResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialServicoSemServicoResponse;
import br.com.giorni.gerenciadororcamento.service.response.OrcamentoResponse;
import br.com.giorni.gerenciadororcamento.service.response.ServicoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public Orcamento save(OrcamentoDTO orcamentoDTO) {
        Orcamento orcamento = OrcamentoMapper.toEntity(orcamentoDTO);
        return orcamentoRepository.save(orcamento);
    }

    public List<OrcamentoResponse> findAll() {
        List<Orcamento> orcamentos = orcamentoRepository.findAll();
        List<OrcamentoResponse> orcamentoResponse = new ArrayList<>();
        List<ServicoResponse> servicoResponse = new ArrayList<>();
        List<MaterialServicoSemServicoResponse> materiais = new ArrayList<>();
        List<AuxiliarSemServicoResponse> auxiliares = new ArrayList<>();

        orcamentos.forEach(orcamento -> {
            if (orcamento.getServicos().size() > 0) {
                orcamento.getServicos().forEach(servico -> {
                    if (servico.getMateriais().size() > 0) {
                        servico.getMateriais().forEach(materialServico -> materiais.add(MaterialServicoMapper.toResponse(materialServico)));
                    }
                    if (servico.getAuxiliares().size() > 0) {
                        servico.getAuxiliares().forEach(auxiliar -> auxiliares.add(AuxiliarMapper.toResponseSemServico(auxiliar)));
                    }
                    servicoResponse.add(ServicoMapper.toResponse(servico, materiais, auxiliares));
                });
            }
            orcamentoResponse.add(OrcamentoMapper.toResponse(orcamento, servicoResponse));
        });
        return orcamentoResponse;
    }

    public Optional<OrcamentoResponse> findById(Long id) {
        Optional<Orcamento> orcamentoOptional = orcamentoRepository.findById(id);
        var orcamentoResponse = new OrcamentoResponse();
        List<ServicoResponse> servicoResponse = new ArrayList<>();
        List<MaterialServicoSemServicoResponse> materiais = new ArrayList<>();
        List<AuxiliarSemServicoResponse> auxiliares = new ArrayList<>();
        if (orcamentoOptional.isPresent()) {
            Orcamento orcamento = orcamentoOptional.get();
            if (orcamento.getServicos().size() > 0) {
                orcamento.getServicos().forEach(servico -> {
                    if (servico.getMateriais().size() > 0) {
                        servico.getMateriais().forEach(materialServico -> materiais.add(MaterialServicoMapper.toResponse(materialServico)));
                    }
                    if (servico.getAuxiliares().size() > 0) {
                        servico.getAuxiliares().forEach(auxiliar -> auxiliares.add(AuxiliarMapper.toResponseSemServico(auxiliar)));
                    }
                    servicoResponse.add(ServicoMapper.toResponse(servico, materiais, auxiliares));
                });
            }
            orcamentoResponse = OrcamentoMapper.toResponse(orcamento, servicoResponse);
            return Optional.of(orcamentoResponse);
        }
        return Optional.empty();
    }

    public OrcamentoResponse update(OrcamentoDTO orcamentoDTO) {
        Orcamento orcamento = OrcamentoMapper.toEntity(orcamentoDTO);
        orcamento = orcamentoRepository.save(orcamento);

        var orcamentoResponse = new OrcamentoResponse();
        List<ServicoResponse> servicoResponse = new ArrayList<>();
        List<MaterialServicoSemServicoResponse> materiais = new ArrayList<>();
        List<AuxiliarSemServicoResponse> auxiliares = new ArrayList<>();

        if (orcamento.getServicos().size() > 0) {
            orcamento.getServicos().forEach(servico -> {
                if (servico.getMateriais().size() > 0) {
                    servico.getMateriais().forEach(materialServico -> materiais.add(MaterialServicoMapper.toResponse(materialServico)));
                }
                if (servico.getAuxiliares().size() > 0) {
                    servico.getAuxiliares().forEach(auxiliar -> auxiliares.add(AuxiliarMapper.toResponseSemServico(auxiliar)));
                }
                servicoResponse.add(ServicoMapper.toResponse(servico, materiais, auxiliares));
            });
        }
        orcamentoResponse = OrcamentoMapper.toResponse(orcamento, servicoResponse);
        return orcamentoResponse;

    }

    public boolean delete(Long id) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        if (orcamento.isPresent()) {
            orcamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Double calcularValorTotalOrcamento(Long id) {
        Orcamento orcamento = orcamentoRepository.findById(id).get();
        var valorTotalServicos = 0.0;
        for (Servico servico : orcamento.getServicos()) {
            valorTotalServicos += servico.getValorTotal();
        }
        valorTotalServicos += (valorTotalServicos * orcamento.getTaxaAuxiliar());
        return valorTotalServicos;
    }
}
