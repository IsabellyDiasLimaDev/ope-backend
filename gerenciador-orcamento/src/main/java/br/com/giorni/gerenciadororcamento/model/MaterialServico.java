package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_material_servico")
public class MaterialServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_material")
    private Material idMaterial;
    @ManyToOne
    @JoinColumn(name="id_servico")
    private Servico idServico;

    public Long getId() {
        return id;
    }
}
