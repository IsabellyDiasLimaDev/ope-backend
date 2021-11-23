package br.com.giorni.gerenciadororcamento.service.mapper;


import br.com.giorni.gerenciadororcamento.model.*;
import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ServicoMapper {

    public static Servico toEntity(ServicoDTO servicoDTO) {
        List<Auxiliar> auxiliares = AuxiliarMapper.listAuxiliarDtoToListAuxiliar(servicoDTO.getAuxiliares());
        List<MaterialServico> materiais = MaterialServicoMapper.listMaterialServicoDtoToListMaterialServico(servicoDTO.getMateriais());
        List<Orcamento> orcamentos = OrcamentoMapper.listOrcamentoDtoToListOrcamento(servicoDTO.getOrcamentos());

        return Servico
                .builder()
                .id(servicoDTO.getId())
                .auxiliares(auxiliares)
                .descricao(servicoDTO.getDescricao())
                .dtFinal(servicoDTO.getDtFinal())
                .dtInicial(servicoDTO.getDtInicial())
                .materiais(materiais)
                .orcamentos(orcamentos)
                .valorMaoDeObra(servicoDTO.getValorMaoDeObra())
                .valorTotal(servicoDTO.getValorTotal())
                .build();
    }

    public static ServicoDTO toDto(Servico servico) {
        List<AuxiliarDTO> auxiliares = AuxiliarMapper.listAuxiliarToListAuxiliarDto(servico.getAuxiliares());
        List<MaterialServicoDTO> materiais = MaterialServicoMapper.listMaterialServicoToListMaterialServicoDto(servico.getMateriais());
        List<OrcamentoDTO> orcamentos = OrcamentoMapper.listOrcamentoToListOrcamentoDto(servico.getOrcamentos());
        return ServicoDTO
                .builder()
                .auxiliares(auxiliares)
                .dtFinal(servico.getDtFinal())
                .id(servico.getId())
                .descricao(servico.getDescricao())
                .dtInicial(servico.getDtInicial())
                .orcamentos(orcamentos)
                .materiais(materiais)
                .valorMaoDeObra(servico.getValorMaoDeObra())
                .valorTotal(servico.getValorTotal())
                .build();
    }

    public static List<Servico> listServicoDtoToListServico(List<ServicoDTO> servicoDTOList){
        List<Servico> servicoList = new ArrayList<>();
        if (servicoDTOList.size() > 0)
            servicoDTOList.forEach(servicoDTO -> servicoList.add(ServicoMapper.toEntity(servicoDTO)));
        return servicoList;
    }

    public static List<ServicoDTO> listServicoToListServicoDto(List<Servico> servicoList){
        List<ServicoDTO> servicoDTOList = new ArrayList<>();
        if (servicoList.size() > 0) servicoList.forEach(servico -> servicoDTOList.add(ServicoMapper.toDto(servico)));
        return servicoDTOList;
    }

}
