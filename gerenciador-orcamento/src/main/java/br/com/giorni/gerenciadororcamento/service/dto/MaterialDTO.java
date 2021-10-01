package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.model.Servico;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


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
    private List<FornecedorDTO> fornecedores;
    @JsonIgnoreProperties({"materiais"})
    private List<ServicoDTO> servicos;

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
        this.fornecedores = fornecedores.stream().map(Fornecedor::toDto).collect(Collectors.toList());
        this.servicos = servicos.stream().map(Servico::toDto).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
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

    public List<FornecedorDTO> getFornecedores() {
        return fornecedores;
    }

    public List<ServicoDTO> getServicos() {
        return servicos;
    }

}
