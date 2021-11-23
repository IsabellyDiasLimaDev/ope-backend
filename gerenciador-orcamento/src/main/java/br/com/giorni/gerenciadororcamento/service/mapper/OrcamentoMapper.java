package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Orcamento;
import br.com.giorni.gerenciadororcamento.model.Servico;
import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrcamentoMapper {

    public static Orcamento toEntity(OrcamentoDTO orcamentoDTO) {
        return Orcamento
                .builder()
                .build();
    }

    public static OrcamentoDTO toDto(Orcamento orcamento) {
        return OrcamentoDTO.builder().build();
    }

    public static List<Orcamento> listOrcamentoDtoToListOrcamento(List<OrcamentoDTO> orcamentoDTOList) {
        List<Orcamento> orcamentoList = new ArrayList<>();
        if (orcamentoDTOList.size() > 0) orcamentoDTOList.forEach(orcamentoDTO -> orcamentoList.add(OrcamentoMapper.toEntity(orcamentoDTO)));
        return orcamentoList;
    }

    public static List<OrcamentoDTO> listOrcamentoToListOrcamentoDto(List<Orcamento> orcamentoList) {
        List<OrcamentoDTO> orcamentoDTOList = new ArrayList<>();
        if (orcamentoList.size() > 0)
            orcamentoList.forEach(orcamento -> orcamentoDTOList.add(OrcamentoMapper.toDto(orcamento)));
        return orcamentoDTOList;
    }

}
