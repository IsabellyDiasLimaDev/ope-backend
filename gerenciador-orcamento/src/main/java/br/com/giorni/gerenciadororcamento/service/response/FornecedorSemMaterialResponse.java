package br.com.giorni.gerenciadororcamento.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FornecedorSemMaterialResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}


