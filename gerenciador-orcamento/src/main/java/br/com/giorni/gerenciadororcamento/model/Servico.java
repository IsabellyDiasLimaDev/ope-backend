package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "valor_mao_de_obra")
    private Double valorMaoDeObra;
    @Column(name = "valor_total")
    private Double valorTotal;
    private String descricao;
    @Column(name = "dt_inicial")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dtInicial;
    @Column(name = "dt_final")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dtFinal;
    @ManyToMany
    @JoinTable(name = "tb_servico_auxiliar",
            joinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auxiliar_id", referencedColumnName = "id"))
    private List<Auxiliar> auxiliares;
    @ManyToMany
    @JoinTable(name = "tb_servico_orcamento",
            joinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orcamento_id", referencedColumnName = "id"))
    private List<Orcamento> orcamentos;

    public Servico(Long id, Double valorMaoDeObra, Double valorTotal, String descricao, LocalDate dtInicial, LocalDate dtFinal) {
        this.id = id;
        this.valorMaoDeObra = valorMaoDeObra;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.auxiliares = new ArrayList<>();
        this.orcamentos = new ArrayList<>();
    }

    public Servico() {
    }

    public Long getId() {
        return id;
    }

    public List<Auxiliar> getAuxiliares() {
        if(auxiliares == null) {
            auxiliares = new ArrayList<>();
        }

        return auxiliares;
    }

    public void setAuxiliares(List<Auxiliar> auxiliares) {
        this.auxiliares = auxiliares;
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

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }

    public void adicionarAuxiliar(Auxiliar auxiliar) {
        if(auxiliar != null && !getAuxiliares().contains(auxiliar)) {
            getAuxiliares().add(auxiliar);

            if(!auxiliar.getServicos().contains(this)) {
                auxiliar.getServicos().add(this);
            }
        }
    }

    public ServicoDTO toDto() { return new ServicoDTO(this.id, this.valorMaoDeObra, this.valorTotal, this.descricao, this.dtInicial, this.dtFinal, this.auxiliares, this.orcamentos); }
}
