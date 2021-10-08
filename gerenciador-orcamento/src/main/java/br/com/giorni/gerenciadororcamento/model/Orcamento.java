package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "tb_orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String observacoes;
    @Column(name = "taxa_auxiliar")
    private String taxaAuxiliar;
    @Column(name = "valor_total")
    private String valorTotal;
    @ManyToMany(mappedBy = "orcamentos")
    private List<Servico> servicos;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    public Orcamento(Long id, String observacoes, String taxaAuxiliar, String valorTotal) {
        this.id = id;
        this.observacoes = observacoes;
        this.taxaAuxiliar = taxaAuxiliar;
        this.valorTotal = valorTotal;
        this.servicos = new ArrayList<>();
    }

    public OrcamentoDTO toDto() {return new OrcamentoDTO(this.id, this.observacoes, this.taxaAuxiliar, this.valorTotal);}
}
