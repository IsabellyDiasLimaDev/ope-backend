package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.Orcamento;
import br.com.giorni.gerenciadororcamento.model.Servico;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoDTO {

    private Long id;
    @JsonProperty("valor_mao_de_obra")
    private Double valorMaoDeObra;
    @JsonProperty("valor_total")
    private Double valorTotal;
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("dt_inicial")
    private LocalDate dtInicial;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("dt_final")
    private LocalDate dtFinal;
    @JsonIgnoreProperties({"servicos"})
    private List<MaterialDTO> materiais;
    @JsonIgnore
    private List<AuxiliarDTO> auxiliares;
    @JsonIgnore
    private List<OrcamentoDTO> orcamentos;

    public ServicoDTO(Long id, Double valorMaoDeObra, Double valorTotal, String descricao, LocalDate dtInicial, LocalDate dtFinal, List<Material> materiais, List<Auxiliar> auxiliares, List<Orcamento> orcamentos) {
        this.id = id;
        this.valorMaoDeObra = valorMaoDeObra;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.materiais = materiais.stream().map(Material::toDto).collect(Collectors.toList());
        this.auxiliares = auxiliares.stream().map(Auxiliar::toDto).collect(Collectors.toList());
        this.orcamentos = orcamentos.stream().map(Orcamento::toDto).collect(Collectors.toList());
    }

    public ServicoDTO() {
    }

    public ServicoDTO(Long id, Double valorMaoDeObra, Double valorTotal, String descricao, LocalDate dtInicial, LocalDate dtFinal, List<Auxiliar> auxiliares, List<Orcamento> orcamentos) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(LocalDate dtInicial) {
        this.dtInicial = dtInicial;
    }

    public LocalDate getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(LocalDate dtFinal) {
        this.dtFinal = dtFinal;
    }

    public List<MaterialDTO> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<MaterialDTO> materiais) {
        this.materiais = materiais;
    }

    public List<AuxiliarDTO> getAuxiliares() {
        return auxiliares;
    }

    public void setAuxiliares(List<AuxiliarDTO> auxiliares) {
        this.auxiliares = auxiliares;
    }

    public List<OrcamentoDTO> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<OrcamentoDTO> orcamentos) {
        this.orcamentos = orcamentos;
    }
}
