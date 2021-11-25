package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String observacoes;
    @Column(name = "taxa_auxiliar")
    private Double taxaAuxiliar;
    @Column(name = "valor_total")
    private Double valorTotal;
    @ManyToMany
    @JoinTable(name = "tb_servico_orcamento",
            joinColumns = @JoinColumn(name = "orcamento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"))
    private List<Servico> servicos;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
