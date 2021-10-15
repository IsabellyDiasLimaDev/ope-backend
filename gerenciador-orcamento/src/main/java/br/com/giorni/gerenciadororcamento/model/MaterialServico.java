package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name="tb_material_servico")
public class MaterialServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="qtd_material")
    private Integer quantidadeMaterial;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "material_id", referencedColumnName = "id")
    private Material material;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "servico_id", referencedColumnName = "id")
    private Servico servico;

    public MaterialServico(Integer quantidadeMaterial, Material material, Servico servico) {
        this.quantidadeMaterial = quantidadeMaterial;
        this.material = material;
        this.servico = servico;
    }

    public MaterialServicoDTO toDto(){
        return new MaterialServicoDTO(this.id, this.quantidadeMaterial, this.material.toDto(), this.servico.toDto());
    }
}
