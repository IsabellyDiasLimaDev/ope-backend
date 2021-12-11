package br.com.giorni.gerenciadororcamento.service.dto;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ServicoDTO {

    Long id;
    @JsonProperty("valor_mao_de_obra")
    Double valorMaoDeObra;
    @JsonProperty("valor_total")
    Double valorTotal;
    String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("data_inicial")
    LocalDate dtInicial;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("data_final")
    LocalDate dtFinal;
    @JsonProperty("material_servico")
    List<MaterialServicoDTO> materiais;
    List<AuxiliarDTO> auxiliares;
    List<OrcamentoDTO> orcamentos;

}
