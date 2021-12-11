package br.com.giorni.gerenciadororcamento.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class OrcamentoDTO {
    Long id;
    String observacoes;
    @JsonProperty("valor_total")
    Double valorTotal;
    List<ServicoDTO> servicos;
    ClienteDTO cliente;
}
