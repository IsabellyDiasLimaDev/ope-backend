package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.Orcamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class ServicoDTO {

    private Long id;
    private Integer quantidadeDisponivel;
    private Double valorMaoDeObra;
    private Double valorTotal;
    private String descricao;
    @JsonFormat(pattern = "dd-MM-YYYY")
    @JsonProperty("dt_inicial")
    private Date dtInicial;
    @JsonFormat(pattern = "dd-MM-YYYY")
    @JsonProperty("dt_final")
    private Date dtFinal;
    private List<Material> materiais;
    private List<Auxiliar> auxiliares;
    private List<Orcamento> orcamentos;

    public ServicoDTO(Long id, Integer quantidadeDisponivel, Double valorMaoDeObra, Double valorTotal, String descricao, Date dtInicial, Date dtFinal, List<Material> materiais, List<Auxiliar> auxiliares, List<Orcamento> orcamentos) {
        this.id = id;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.valorMaoDeObra = valorMaoDeObra;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.materiais = materiais;
        this.auxiliares = auxiliares;
        this.orcamentos = orcamentos;
    }

    public ServicoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Double getValorMaoDeObra() {
        return valorMaoDeObra;
    }

    public void setValorMaoDeObra(Double valorMaoDeObra) {
        this.valorMaoDeObra = valorMaoDeObra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public List<Auxiliar> getAuxiliares() {
        return auxiliares;
    }

    public void setAuxiliares(List<Auxiliar> auxiliares) {
        this.auxiliares = auxiliares;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
}
