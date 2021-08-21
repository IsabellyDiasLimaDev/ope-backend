package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;;
    private String numero;
    private String cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String estado;
    @OneToMany
    private Set<EnderecoOrcamento> enderecoOrcamentos;
}
