package br.com.giorni.gerenciadororcamento.service;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.repository.AuxiliarRepository;
import br.com.giorni.gerenciadororcamento.repository.MaterialRepository;
import br.com.giorni.gerenciadororcamento.repository.OrcamentoRepository;
import br.com.giorni.gerenciadororcamento.repository.ServicoRepository;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoSemMaterialDTO;
import br.com.giorni.gerenciadororcamento.service.mapper.AuxiliarMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.MaterialServicoMapper;
import br.com.giorni.gerenciadororcamento.service.mapper.ServicoMapper;
import br.com.giorni.gerenciadororcamento.service.response.AuxiliarSemServicoResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialServicoSemServicoResponse;
import br.com.giorni.gerenciadororcamento.service.response.ServicoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private AuxiliarRepository auxiliarRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialServicoService materialServicoService;

    public boolean save(ServicoDTO servicoDTO) {
        Servico servico = ServicoMapper.toEntity(servicoDTO);
        for (Auxiliar auxiliar:
             servico.getAuxiliares()) {
            auxiliar.setDisponibilidade(false);
            auxiliarRepository.save(auxiliar);
        }
        servico = servicoRepository.save(servico);
       try{
           for (MaterialServico materialServico:
                   servico.getMateriais()) {
               materialServico.setServico(servico);
               materialServico.AtualizarQuantidadeMaterial();
               materialRepository.save(materialServico.getMaterial());
               materialServicoService.save(materialServico);
           }
           return true;
       }catch (Exception e){
           return false;
       }



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

    public List<ServicoSemMaterialDTO> findAllWithoutMaterial(){
        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoSemMaterialDTO> servicoSemMaterial = new ArrayList<>();
        servicos.forEach(servico -> {
            servicoSemMaterial.add(ServicoMapper.toDtoSemMaterial(servico));
        });
         return servicoSemMaterial;
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

    public Double calcularValorTotalServico(Long id){
        Optional<Servico> servico = servicoRepository.findById(id);
        List<Double> valorTotalMateriaisList = new ArrayList<>();
        double valorTotalMateriais = 0.0;
        servico.get().getMateriais().forEach(materialServico -> {
            double valorTotalMaterial = materialServico.getMaterial().getPreco() * materialServico.getQuantidadeMaterial();
            valorTotalMateriaisList.add(valorTotalMaterial);
        });
        for (Double valor : valorTotalMateriaisList) {
            valorTotalMateriais += valor;
        }
        return valorTotalMateriais + servico.get().getValorMaoDeObra();
    }
}
