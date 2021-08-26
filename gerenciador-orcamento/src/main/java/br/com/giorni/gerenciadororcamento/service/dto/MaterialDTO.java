package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.model.Servico;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class MaterialDTO {

    private Long id;
    private Double preco;
    private String tipo;
    private String categoria;
    @JsonProperty("quantidade_disponivel")
    private Integer quantidadeDisponivel;
    private String descricao;
    private String cor;
    @JsonIgnore
    private List<Fornecedor> fornecedores;
    @JsonIgnoreProperties({"materiais"})
    private List<Servico> servicos;

    public MaterialDTO() {
    }

    public MaterialDTO(Long id, Double preco, String tipo, String categoria, Integer quantidadeDisponivel, String descricao, String cor, List<Fornecedor> fornecedores, List<Servico> servicos) {
        this.id = id;
        this.preco = preco;
        this.tipo = tipo;
        this.categoria = categoria;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.descricao = descricao;
        this.cor = cor;
        this.fornecedores = fornecedores;
        this.servicos = servicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
