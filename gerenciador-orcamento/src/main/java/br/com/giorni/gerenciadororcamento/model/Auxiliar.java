package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_auxiliar")
public class Auxiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String telefone;
    private String nome;
    @Column(name = "tipo_servico")
    private String tipoServico;
    private String email;
    @OneToMany
    Set<ServicoAuxiliar> servicoAuxiliar;

    public Long getId() {
        return id;
    }
}
