package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private Long id;
    private Double preco;
    private String tipo;
    private String categoria;
    @JsonProperty("quantidade_disponivel")
    private Integer quantidadeDisponivel;
    private String descricao;
    private String cor;
    private List<Fornecedor> fornecedores;
    private List<ServicoDTO> servicos;


}
