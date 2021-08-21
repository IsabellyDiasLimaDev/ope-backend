package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
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

    @OneToMany
    private Set<EnderecoOrcamento> enderecoOrcamentos;
    @OneToMany
    Set<ServicoOrcamento> servicoOrcamento;

    public Long getId() {
        return id;
    }

}
