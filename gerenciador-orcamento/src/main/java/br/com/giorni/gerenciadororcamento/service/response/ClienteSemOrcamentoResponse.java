package br.com.giorni.gerenciadororcamento.service.response;

import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteSemOrcamentoResponse {
    private Long id;
    @JsonProperty("tipo_cliente")
    private String tipoCliente;
    private String email;
    private String nome;
    private EnderecoResponse endereco;
    @JsonProperty("cpf_cnpj")
    private String cpfCnpj;
    private String telefone;
}
