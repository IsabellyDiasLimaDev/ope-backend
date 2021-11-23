package br.com.giorni.gerenciadororcamento.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FornecedorResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<MaterialSemFornecedorResponse> materiais;
}
