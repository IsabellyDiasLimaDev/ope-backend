package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.AuxiliarDTO;
import br.com.giorni.gerenciadororcamento.service.dto.Default;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private boolean disponibilidade;
    private String email;
    @ManyToMany(mappedBy = "auxiliares")
    @JsonIgnore
    private List<Servico> servicos;

    public List<Servico> getServicos() {
        if(servicos == null) {
            servicos = new ArrayList<>();
        }
        return servicos;
    }

    public void adicionarServico(Servico servico) {
        if(servico != null && !getServicos().contains(servico)) {
            getServicos().add(servico);

            if(!servico.getAuxiliares().contains(this)) {
                servico.getAuxiliares().add(this);
            }
        }
    }

}
