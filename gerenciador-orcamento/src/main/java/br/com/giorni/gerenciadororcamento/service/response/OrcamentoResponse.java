package br.com.giorni.gerenciadororcamento.service.response;

import br.com.giorni.gerenciadororcamento.service.dto.ClienteDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrcamentoResponse {
    private Long id;
    private String observacoes;
    @JsonProperty("valor_total")
    private Double valorTotal;
    private List<ServicoResponse> servicos;
    private ClienteSemOrcamentoResponse cliente;
}
