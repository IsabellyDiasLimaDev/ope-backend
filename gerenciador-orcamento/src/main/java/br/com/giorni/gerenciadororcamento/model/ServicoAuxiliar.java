package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_servico_auxiliar")
public class ServicoAuxiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_auxiliar")
    private Auxiliar idAuxiliar;
    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico idServico;

    public Long getId() {
        return id;
    }
}
