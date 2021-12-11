package br.com.giorni.gerenciadororcamento.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class AuxiliarDTO {
    Long id;
    String telefone;
    String nome;
    @JsonProperty("tipo_servico")
    String tipoServico;
    boolean disponibilidade;
    String email;
    @JsonIgnore
    List<ServicoDTO> servicos;

}
