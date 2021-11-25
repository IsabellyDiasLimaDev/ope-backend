package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.service.dto.FornecedorDTO;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorResponse;
import br.com.giorni.gerenciadororcamento.service.response.FornecedorSemMaterialResponse;
import br.com.giorni.gerenciadororcamento.service.response.MaterialSemFornecedorResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FornecedorMapper {

    public static Fornecedor toEntity(FornecedorDTO fornecedorDTO) {
        if (fornecedorDTO.getMateriais() != null) {
            List<Material> materiais = fornecedorDTO.getMateriais().stream().map(MaterialMapper::toEntity).collect(Collectors.toList());
            return Fornecedor.builder()
                    .id(fornecedorDTO.getId())
                    .email(fornecedorDTO.getEmail())
                    .materiais(materiais)
                    .nome(fornecedorDTO.getNome())
                    .telefone(fornecedorDTO.getTelefone())
                    .build();
        }
        return Fornecedor.builder()
                .id(fornecedorDTO.getId())
                .email(fornecedorDTO.getEmail())
                .nome(fornecedorDTO.getNome())
                .telefone(fornecedorDTO.getTelefone())
                .build();
    }

    public static FornecedorDTO toDto(Fornecedor fornecedor) {
        if (fornecedor.getMateriais() != null) {
            List<MaterialDTO> materiais = fornecedor.getMateriais().stream().map(MaterialMapper::toDto).collect(Collectors.toList());
            return FornecedorDTO
                    .builder()
                    .email(fornecedor.getEmail())
                    .id(fornecedor.getId())
                    .materiais(materiais)
                    .nome(fornecedor.getNome())
                    .telefone(fornecedor.getTelefone())
                    .build();
        }
        return FornecedorDTO
                .builder()
                .email(fornecedor.getEmail())
                .id(fornecedor.getId())
                .nome(fornecedor.getNome())
                .telefone(fornecedor.getTelefone())
                .build();
    }

    public static FornecedorSemMaterialResponse toResponseSemMaterial(Fornecedor fornecedor){
        return FornecedorSemMaterialResponse
                .builder()
                .id(fornecedor.getId())
                .email(fornecedor.getEmail())
                .nome(fornecedor.getNome())
                .telefone(fornecedor.getTelefone())
                .build();
    }

    public static FornecedorResponse toResponse(Fornecedor fornecedor, List<MaterialSemFornecedorResponse> materiais){
        return FornecedorResponse
                .builder()
                .id(fornecedor.getId())
                .email(fornecedor.getEmail())
                .nome(fornecedor.getNome())
                .telefone(fornecedor.getTelefone())
                .materiais(materiais)
                .build();
    }

}
