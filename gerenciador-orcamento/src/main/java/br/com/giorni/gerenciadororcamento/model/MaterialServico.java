package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_material_servico")
public class MaterialServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "qtd_material", nullable = false)
    private Integer qtdMaterial;
    @ManyToOne
    private Material material;
    @ManyToOne
    private Servico servico;

}
