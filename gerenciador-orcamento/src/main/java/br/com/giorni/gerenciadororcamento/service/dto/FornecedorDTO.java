package br.com.giorni.gerenciadororcamento.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class FornecedorDTO {
    Long id;
    String nome;
    String email;
    String telefone;
    List<MaterialDTO> materiais;
}
