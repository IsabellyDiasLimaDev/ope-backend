package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_servico_orcamento")
public class ServicoOrcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico idServico;
    @ManyToOne
    @JoinColumn(name = "id_orcamento")
    private Orcamento idOrcamento;

    public Long getId() {
        return id;
    }
}
