package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.response.MaterialServicoSemServicoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MaterialServicoMapper {

    public static MaterialServico toEntity(MaterialServicoDTO materialServicoDTO){
        if (materialServicoDTO.getServico() != null){
            return MaterialServico
                    .builder()
                    .servico(ServicoMapper.toEntity(materialServicoDTO.getServico()))
                    .id(materialServicoDTO.getId())
                    .quantidadeMaterial(materialServicoDTO.getQuantidadeMaterial())
                    .material(MaterialMapper.toEntity(materialServicoDTO.getMaterial()))
                    .build();
        }
        return MaterialServico
                .builder()
                .id(materialServicoDTO.getId())
                .quantidadeMaterial(materialServicoDTO.getQuantidadeMaterial())
                .material(MaterialMapper.toEntity(materialServicoDTO.getMaterial()))
                .build();
    }

    public static MaterialServicoDTO toDto(MaterialServico materialServico){
        return MaterialServicoDTO
                .builder()
                .quantidadeMaterial(materialServico.getQuantidadeMaterial())
                .material(MaterialMapper.toDto(materialServico.getMaterial()))
                .id(materialServico.getId())
                .build();
    }

    public static List<MaterialServico> listMaterialServicoDtoToListMaterialServico(List<MaterialServicoDTO> materialServicoDTOList){
        List<MaterialServico> materialServico = new ArrayList<>();
        if (materialServicoDTOList.size() > 0){
            materialServicoDTOList.forEach(materialServicoDTO -> materialServico.add(MaterialServicoMapper.toEntity(materialServicoDTO)));
        }
        return materialServico;
    }

    public static List<MaterialServicoDTO> listMaterialServicoToListMaterialServicoDto(List<MaterialServico> materialServicoList) {
        List<MaterialServicoDTO> materialServicoDTOList = new ArrayList<>();
        if (materialServicoList.size() > 0) {
            materialServicoList.forEach(materialServico -> materialServicoDTOList.add(MaterialServicoMapper.toDto(materialServico)));
        }
        return materialServicoDTOList;
    }

    public static MaterialServicoSemServicoResponse toResponse(MaterialServico materialServico){
        return MaterialServicoSemServicoResponse
                .builder()
                .informacoesSobreOMaterial(MaterialMapper.toResponseSemFornecedor(materialServico.getMaterial()))
                .quantidadeMaterialNoServico(materialServico.getQuantidadeMaterial())
                .build();
    }

}
