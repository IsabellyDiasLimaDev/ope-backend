package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Servico;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class MaterialServicoDTO {
    Long id;
    Integer quantidadeMaterial;
    MaterialDTO material;
    @JsonIgnore
    ServicoDTO servico;

    public MaterialServico toEntity() {
        return new MaterialServico(this.id, this.quantidadeMaterial, this.material.toEntity(), this.servico.toEntity());
    }
}
