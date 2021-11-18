package br.com.giorni.gerenciadororcamento.service.dto;


import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import br.com.giorni.gerenciadororcamento.model.Orcamento;
import br.com.giorni.gerenciadororcamento.model.Servico;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
@AllArgsConstructor(onConstructor_={@Default})
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
    @JsonProperty("dt_inicial")
    LocalDate dtInicial;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("dt_final")
    LocalDate dtFinal;
    List<AuxiliarDTO> auxiliaresDto;
    List<OrcamentoDTO> orcamentosDto;
    List<MaterialServicoDTO> materiaisDto;

    public Servico toEntity(){
        var materiais = materiaisDto.stream().map(MaterialServicoDTO::toEntity).collect(Collectors.toList());
        var  auxiliares = auxiliaresDto.stream().map(AuxiliarDTO::toEntity).collect(Collectors.toList());
        var  orcamentos =  orcamentosDto.stream().map(OrcamentoDTO::toEntity).collect(Collectors.toList());
        return new Servico(this.id, this.valorMaoDeObra, this.valorTotal, this.descricao, this.dtInicial, this.dtFinal, auxiliares, orcamentos,materiais);
    }
}
