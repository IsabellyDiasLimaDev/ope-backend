package br.com.giorni.gerenciadororcamento.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class MaterialDTO {

    Long id;
    Double preco;
    String tipo;
    String categoria;
    @JsonProperty("quantidade_disponivel")
    Integer quantidadeDisponivel;
    String descricao;
    String cor;
    List<FornecedorDTO> fornecedores;
}
