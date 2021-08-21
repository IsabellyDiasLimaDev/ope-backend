package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
