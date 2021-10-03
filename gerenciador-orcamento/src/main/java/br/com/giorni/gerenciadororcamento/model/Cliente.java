package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.ClienteDTO;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne
    private Endereco endereco;
    @OneToMany
    private List<Orcamento> orcamentos;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    private String telefone;

    public Long getId() {
        return id;
    }

    public ClienteDTO toDto() { return new ClienteDTO(this.id, this.tipoCliente, this.email, this.nome, this.endereco, this.cpfCnpj, this.telefone);}
}
