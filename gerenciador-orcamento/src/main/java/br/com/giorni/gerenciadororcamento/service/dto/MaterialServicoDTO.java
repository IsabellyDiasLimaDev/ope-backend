package br.com.giorni.gerenciadororcamento.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class MaterialServicoDTO {
    Long id;
    Integer quantidadeMaterial;
    MaterialDTO material;
    ServicoDTO servico;
}
