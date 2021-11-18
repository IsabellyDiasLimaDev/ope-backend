package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_={@Default})
public class FornecedorDTO {
    Long id;
    String nome;
    String email;
    String telefone;

    public  Fornecedor toEntity() {
        return new Fornecedor(this.id, this.nome, this.email, this.telefone);
    }
}
