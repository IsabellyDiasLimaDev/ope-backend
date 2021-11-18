package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.Default;
import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(onConstructor_ = {@Default})
@Table(name = "tb_auxiliar")
public class Auxiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String telefone;
    private String nome;
    @Column(name = "tipo_servico")
    private String tipoServico;
    private boolean disponbibilidade;
    private String email;
    @ManyToMany(mappedBy = "auxiliares")
    private List<Servico> servicos;

    public AuxiliarDTO toDto() {
        var servicoDTO = servicos.stream().map(Servico::toDto).collect(Collectors.toList());
        return new AuxiliarDTO(this.id, this.telefone, this.nome, this.tipoServico, this.disponbibilidade, this.email, servicoDTO);
    }
}
