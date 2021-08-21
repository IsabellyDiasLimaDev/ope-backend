package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double preco;
    private String tipo;
    private String categoria;
    @Column(name = "quantidade_disponivel")
    private Integer quantidadeDisponivel;
    private String descricao;
    private String cor;
    @OneToMany
    Set<FornecedorMaterial> fornecedorMateriais;
    @OneToMany
    Set<MaterialServico> materialServicos;

    public Long getId() {
        return id;
    }
}
