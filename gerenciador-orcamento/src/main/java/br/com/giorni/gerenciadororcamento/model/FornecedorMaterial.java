package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_fornecedor_material")
public class FornecedorMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material idMaterial;
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor idFornecedor;

    public Long getId() {
        return id;
    }
}
