package br.com.giorni.gerenciadororcamento.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuxiliarResponse {
    private Long id;
    private String telefone;
    private String nome;
    @JsonProperty("tipo_servico")
    private String tipoServico;
    private boolean disponbibilidade;
    private String email;
}
