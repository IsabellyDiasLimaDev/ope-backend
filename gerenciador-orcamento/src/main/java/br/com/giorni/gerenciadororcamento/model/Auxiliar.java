package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.List;
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
    private boolean disponbibilidade;
    private String email;
    @ManyToMany(mappedBy = "auxiliares")
    private List<Servico> servicos;

    public Long getId() {
        return id;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
