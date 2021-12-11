package br.com.giorni.gerenciadororcamento.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrestanteResponse {

    private Long id;
    private UsuarioResponse login;
    private String nome;
    private EmpresaResponse empresa;
    private String telefone;

}
