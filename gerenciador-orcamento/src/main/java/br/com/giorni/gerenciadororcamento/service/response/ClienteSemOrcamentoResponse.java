package br.com.giorni.gerenciadororcamento.service.response;

import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
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
    private String tipoCliente;
    private String email;
    private String nome;
    private EnderecoResponse endereco;
    private String cpfCnpj;
    private String telefone;
}
