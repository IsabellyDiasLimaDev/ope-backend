package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
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

    @ManyToMany(mappedBy = "materiais")
    private List<Fornecedor> fornecedores;

    public Material(Long id, Double preco, String tipo, String categoria, Integer quantidadeDisponivel, String descricao, String cor) {
        this.id = id;
        this.preco = preco;
        this.tipo = tipo;
        this.categoria = categoria;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.descricao = descricao;
        this.cor = cor;
        this.fornecedores = new ArrayList<>();
    }


    public List<Fornecedor> getFornecedores() {
        if(fornecedores == null) {
            fornecedores = new ArrayList<>();
        }
        return fornecedores;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        if(fornecedor != null && !getFornecedores().contains(fornecedor)) {
            getFornecedores().add(fornecedor);

            if(!fornecedor.getMateriais().contains(this)) {
                fornecedor.getMateriais().add(this);
            }
        }
    }

    public MaterialDTO toDto() {
        var fornecedorDTO = fornecedores.stream().map(Fornecedor::toDto).collect(Collectors.toList());
        return new MaterialDTO(this.id, this.preco, this.tipo, this.categoria, this.quantidadeDisponivel, this.descricao, this.cor, fornecedorDTO);
    }
}
