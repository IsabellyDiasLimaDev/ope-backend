package br.com.giorni.gerenciadororcamento.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class MaterialServicoDTO {
    Long id;
    Integer quantidadeMaterial;
    MaterialDTO material;
    @JsonIgnore
    ServicoDTO servico;
}
