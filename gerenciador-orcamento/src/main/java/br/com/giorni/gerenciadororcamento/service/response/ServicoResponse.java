package br.com.giorni.gerenciadororcamento.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoResponse {
    private Long id;
    @JsonProperty("valor_mao_de_obra")
    private Double valorMaoDeObra;
    @JsonProperty("valor_total")
    private Double valorTotal;
    private String descricao;
    @JsonProperty("data_inicial")
    private LocalDate dtInicial;
    @JsonProperty("data_final")
    private LocalDate dtFinal;
    private List<MaterialServicoSemServicoResponse> materiais;
    private List<AuxiliarSemServicoResponse> auxiliares;

}
