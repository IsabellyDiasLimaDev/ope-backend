package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class MaterialServicoSemServicoDTO {
    private Long id;
    private Integer quantidadeMaterial;
    private MaterialDTO material;
}
