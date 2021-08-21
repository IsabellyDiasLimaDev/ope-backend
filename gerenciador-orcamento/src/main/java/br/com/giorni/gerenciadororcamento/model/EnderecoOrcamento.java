package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_endereco_orcamento")
public class EnderecoOrcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_orcamento")
    private Orcamento idOrcamento;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco idEndereco;

    public Long getId() {
        return id;
    }
}
