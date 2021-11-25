package br.com.giorni.gerenciadororcamento.service.mapper;


import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.service.dto.FornecedorDTO;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorSemMaterialResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialSemFornecedorResponse;

import java.util.List;
import java.util.stream.Collectors;

public class MaterialMapper {

    public static Material toEntity(MaterialDTO materialDTO) {
        if (materialDTO.getFornecedores() != null){
            List<Fornecedor> fornecedores = materialDTO.getFornecedores().stream().map(FornecedorMapper::toEntity).collect(Collectors.toList());
            return Material
                    .builder()
                    .id(materialDTO.getId())
                    .preco(materialDTO.getPreco())
                    .tipo(materialDTO.getTipo())
                    .categoria(materialDTO.getCategoria())
                    .descricao(materialDTO.getDescricao())
                    .cor(materialDTO.getCor())
                    .fornecedores(fornecedores)
                    .quantidadeDisponivel(materialDTO.getQuantidadeDisponivel())
                    .tipo(materialDTO.getTipo())
                    .build();
        }
        return Material
                .builder()
                .id(materialDTO.getId())
                .preco(materialDTO.getPreco())
                .tipo(materialDTO.getTipo())
                .categoria(materialDTO.getCategoria())
                .descricao(materialDTO.getDescricao())
                .cor(materialDTO.getCor())
                .quantidadeDisponivel(materialDTO.getQuantidadeDisponivel())
                .tipo(materialDTO.getTipo())
                .build();
    }

    public static MaterialDTO toDto(Material material) {
        if (material.getFornecedores() != null){
            List<FornecedorDTO> fornecedores = material.getFornecedores().stream().map(FornecedorMapper::toDto).collect(Collectors.toList());
            return MaterialDTO
                    .builder()
                    .id(material.getId())
                    .cor(material.getCor())
                    .categoria(material.getCategoria())
                    .descricao(material.getDescricao())
                    .fornecedores(fornecedores)
                    .preco(material.getPreco())
                    .quantidadeDisponivel(material.getQuantidadeDisponivel())
                    .tipo(material.getTipo())
                    .build();
        }
        return MaterialDTO
                .builder()
                .id(material.getId())
                .cor(material.getCor())
                .categoria(material.getCategoria())
                .descricao(material.getDescricao())
                .preco(material.getPreco())
                .quantidadeDisponivel(material.getQuantidadeDisponivel())
                .tipo(material.getTipo())
                .build();
    }

    public static MaterialResponse toResponse(Material material, List<FornecedorSemMaterialResponse> fornecedorSemMaterialResponseList){
        return MaterialResponse
                .builder()
                .id(material.getId())
                .categoria(material.getCategoria())
                .cor(material.getCor())
                .descricao(material.getDescricao())
                .preco(material.getPreco())
                .quantidadeDisponivel(material.getQuantidadeDisponivel())
                .tipo(material.getTipo())
                .fornecedores(fornecedorSemMaterialResponseList)
                .build();
    }

    public static MaterialSemFornecedorResponse toResponseSemFornecedor(Material material){
        return MaterialSemFornecedorResponse
                .builder()
                .id(material.getId())
                .categoria(material.getCategoria())
                .cor(material.getCor())
                .descricao(material.getDescricao())
                .preco(material.getPreco())
                .quantidadeDisponivel(material.getQuantidadeDisponivel())
                .tipo(material.getTipo())
                .build();
    }

}
