package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Auxiliar;
import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Value
@AllArgsConstructor(onConstructor_ = {@Default})
public class AuxiliarDTO {
    Long id;
    String telefone;
    String nome;
    String tipoServico;
    boolean disponbibilidade;
    String email;
    List<ServicoDTO> servicos;

    public Auxiliar toEntity() {
        var servicoDto = servicos.stream().map(ServicoDTO::toEntity).collect(Collectors.toList());
        return new Auxiliar(this.id, this.telefone, this.nome, this.tipoServico, this.disponbibilidade, this.email, servicoDto);
    }

}
