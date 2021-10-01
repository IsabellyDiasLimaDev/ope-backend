package br.com.giorni.gerenciadororcamento.service.dto;

import javax.persistence.Column;

public class OrcamentoDTO {
    private Long id;
    private String observacoes;
    private String taxaAuxiliar;
    private String valorTotal;

    public OrcamentoDTO(Long id, String observacoes, String taxaAuxiliar, String valorTotal) {
        this.id = id;
        this.observacoes = observacoes;
        this.taxaAuxiliar = taxaAuxiliar;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getTaxaAuxiliar() {
        return taxaAuxiliar;
    }

    public String getValorTotal() {
        return valorTotal;
    }
}
