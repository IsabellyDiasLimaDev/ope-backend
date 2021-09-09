package br.com.giorni.gerenciadororcamento.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("quantidade_disponivel")
    private Integer quantidadeDisponivel;
    private String descricao;
    private String cor;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<MaterialServico> materiais = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="tb_fornecedor_material",
            joinColumns = @JoinColumn(name="fornecedor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="material_id", referencedColumnName = "id")
    )
    private List<Fornecedor> fornecedores;
    @ManyToMany(cascade= {CascadeType.ALL})
    @JsonIgnoreProperties({"materiais"})
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

    public Material(){}

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

    public Double getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        if(fornecedor != null && !getFornecedores().contains(fornecedor)) {
            getFornecedores().add(fornecedor);

            if(!fornecedor.getMateriais().contains(this)) {
                fornecedor.getMateriais().add(this);
            }
        }
    }

    public void adicionarServico(MaterialServico materiais) {
        materiais.setMaterial(this);
        this.getMateriais().add(materiais);
    }

    public List<MaterialServico> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<MaterialServico> materiais) {
        this.materiais = materiais;
    }
}
