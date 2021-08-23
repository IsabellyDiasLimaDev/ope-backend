package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    @ManyToMany
    @JoinTable(
            name="tb_fornecedor_material",
            joinColumns = @JoinColumn(name="fornecedor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="material_id", referencedColumnName = "id")
    )
    private List<Fornecedor> fornecedores;
    @ManyToMany
    @JoinTable(
            name="tb_material_servico",
            joinColumns = @JoinColumn(name="material_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="servico_id", referencedColumnName = "id")
    )
    private List<Servico> servicos;

    public Material(Long id, Double preco, String tipo, String categoria, Integer quantidadeDisponivel, String descricao, String cor) {
        this.id = id;
        this.preco = preco;
        this.tipo = tipo;
        this.categoria = categoria;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.descricao = descricao;
        this.cor = cor;
        this.fornecedores = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Fornecedor> getFornecedores() {
        if(fornecedores == null) {
            fornecedores = new ArrayList<>();
        }
        return fornecedores;
    }

    public List<Servico> getServicos() {
        if(servicos == null) {
            servicos = new ArrayList<>();
        }
        return servicos;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        if(fornecedor != null && !getFornecedores().contains(fornecedor)) {
            getFornecedores().add(fornecedor);

            if(!fornecedor.getMateriais().contains(this)) {
                fornecedor.getMateriais().add(this);
            }
        }
    }

    public void adicionarServico(Servico servico) {
        if(servico != null && !getServicos().contains(servico)) {
            getServicos().add(servico);

            if(!servico.getMateriais().contains(this)) {
                servico.getMateriais().add(this);
            }
        }
    }
}
