package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class OrcamentoDTO {
    private Long id;
    private String observacoes;
    private String taxaAuxiliar;
    private String valorTotal;
}
