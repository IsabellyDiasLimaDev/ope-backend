package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
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

    public Long getId() {
        return id;
    }

    public Orcamento(Long id, String observacoes, String taxaAuxiliar, String valorTotal) {
        this.id = id;
        this.observacoes = observacoes;
        this.taxaAuxiliar = taxaAuxiliar;
        this.valorTotal = valorTotal;
        this.servicos = new ArrayList<>();
    }
}
