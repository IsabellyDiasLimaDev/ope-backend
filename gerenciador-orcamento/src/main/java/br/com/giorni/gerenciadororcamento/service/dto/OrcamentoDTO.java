package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Orcamento;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = {@Default})
public class OrcamentoDTO {
    Long id;
    String observacoes;
    String taxaAuxiliar;
    String valorTotal;

    public Orcamento toEntity() {
        return new Orcamento(this.id, this.observacoes, this.taxaAuxiliar, this.valorTotal);
    }
}
