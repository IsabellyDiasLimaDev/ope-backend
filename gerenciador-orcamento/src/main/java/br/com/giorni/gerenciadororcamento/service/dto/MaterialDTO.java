package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import br.com.giorni.gerenciadororcamento.model.Fornecedor;
import br.com.giorni.gerenciadororcamento.model.Material;
import br.com.giorni.gerenciadororcamento.model.MaterialServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
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

    public Material toEntity(){
        var fornecedorDto = fornecedores.stream().map(FornecedorDTO::toEntity).collect(Collectors.toList());
        return new Material(this.id, this.preco,this.tipo, this.categoria, this.quantidadeDisponivel, this.descricao, this.cor, fornecedorDto);
    }
}
