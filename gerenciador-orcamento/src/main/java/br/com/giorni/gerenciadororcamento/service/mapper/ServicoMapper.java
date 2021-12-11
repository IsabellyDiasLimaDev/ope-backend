package br.com.giorni.gerenciadororcamento.service.mapper;


import br.com.giorni.gerenciadororcamento.model.*;
import br.com.giorni.gerenciadororcamento.service.dto.*;
import br.com.giorni.gerenciadororcamento.service.response.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ServicoMapper {

    public static Servico toEntity(ServicoDTO servicoDTO) {
        List<Auxiliar> auxiliares = new ArrayList<>();
        List<MaterialServico> materiais = new ArrayList<>();
        List<Orcamento> orcamentos = new ArrayList<>();
        if (servicoDTO.getAuxiliares() != null) {
            auxiliares = AuxiliarMapper.listAuxiliarDtoToListAuxiliar(servicoDTO.getAuxiliares());
        }
        if (servicoDTO.getMateriais() != null) {
            materiais = MaterialServicoMapper.listMaterialServicoDtoToListMaterialServico(servicoDTO.getMateriais());
        }
        if (servicoDTO.getOrcamentos() != null) {
            orcamentos = OrcamentoMapper.listOrcamentoDtoToListOrcamento(servicoDTO.getOrcamentos());
        }

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
        List<AuxiliarDTO> auxiliares = new ArrayList<>();
        List<MaterialServicoDTO> materiais = new ArrayList<>();
        List<OrcamentoDTO> orcamentos = new ArrayList<>();
        if (servico.getAuxiliares() != null) {
            auxiliares = AuxiliarMapper.listAuxiliarToListAuxiliarDto(servico.getAuxiliares());
        }
        if (servico.getMateriais() != null) {
            materiais = MaterialServicoMapper.listMaterialServicoToListMaterialServicoDto(servico.getMateriais());
        }
        if (servico.getOrcamentos() != null) {
            orcamentos = OrcamentoMapper.listOrcamentoToListOrcamentoDto(servico.getOrcamentos());
        }

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

    public static List<Servico> listServicoDtoToListServico(List<ServicoDTO> servicoDTOList) {
        List<Servico> servicoList = new ArrayList<>();
        if (servicoDTOList.size() > 0)
            servicoDTOList.forEach(servicoDTO -> servicoList.add(ServicoMapper.toEntity(servicoDTO)));
        return servicoList;
    }

    public static List<ServicoDTO> listServicoToListServicoDto(List<Servico> servicoList) {
        List<ServicoDTO> servicoDTOList = new ArrayList<>();
        if (servicoList.size() > 0) servicoList.forEach(servico -> servicoDTOList.add(ServicoMapper.toDto(servico)));
        return servicoDTOList;
    }

    public static ServicoResponse toResponse(Servico servico,
                                             List<MaterialServicoSemServicoResponse> materialServico,
                                             List<AuxiliarSemServicoResponse> auxiliares) {
        return ServicoResponse
                .builder()
                .id(servico.getId())
                .descricao(servico.getDescricao())
                .dtFinal(servico.getDtFinal())
                .dtInicial(servico.getDtInicial())
                .materiais(materialServico)
                .auxiliares(auxiliares)
                .valorMaoDeObra(servico.getValorMaoDeObra())
                .valorTotal(servico.getValorTotal())
                .build();
    }

    public static ServicoSemMaterialDTO toDtoSemMaterial(Servico servico){
        List<AuxiliarDTO> auxiliarDTOList = new ArrayList<>();
        servico.getAuxiliares().forEach(auxiliar -> {
            auxiliarDTOList.add(AuxiliarDTO
                    .builder()
                            .tipoServico(auxiliar.getTipoServico())
                            .email(auxiliar.getEmail())
                            .nome(auxiliar.getNome())
                            .id(auxiliar.getId())
                            .telefone(auxiliar.getTelefone())
                    .build());
        });
        return ServicoSemMaterialDTO
                .builder()
                .id(servico.getId())
                .descricao(servico.getDescricao())
                .dtFinal(servico.getDtFinal())
                .dtInicial(servico.getDtInicial())
                .valorTotal(servico.getValorTotal())
                .valorMaoDeObra(servico.getValorMaoDeObra())
                .auxiliares(auxiliarDTOList)
                .build();
    }

}
