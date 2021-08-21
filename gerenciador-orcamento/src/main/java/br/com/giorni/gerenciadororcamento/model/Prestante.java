package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_prestante")
public class Prestante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario login;
    @OneToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;
    private String nome;
    private String telefone;
    private String email;


}
