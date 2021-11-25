package br.com.giorni.gerenciadororcamento.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_={@Default})
public class OrcamentoDTO {
    Long id;
    String observacoes;
    Double taxaAuxiliar;
    Double valorTotal;
    List<ServicoDTO> servicos;
    ClienteDTO cliente;
}
