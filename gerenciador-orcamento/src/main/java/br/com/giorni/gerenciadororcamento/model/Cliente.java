package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "tipo_cliente")
    private String tipoCliente;
    private String email;
    private String nome;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    private String telefone;

    public Long getId() {
        return id;
    }
}
