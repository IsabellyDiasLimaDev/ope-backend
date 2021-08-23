package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "quantidade_disponivel")
    private Integer quantidadeDisponivel;
    @Column(name = "valor_mao_de_obra")
    private Double valorMaoDeObra;
    @Column(name = "valor_total")
    private Double valorTotal;
    private String descricao;
    @Column(name = "dt_inicial")
    private Date dtInicial;
    @Column(name = "dt_final")
    private Date dtFinal;
    @ManyToMany(mappedBy = "servicos")
    private List<Material> materiais;
    @ManyToMany
    @JoinTable(name = "tb_servico_auxiliar",
            joinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auxiliar_id", referencedColumnName = "id"))
    private List<Auxiliar> auxiliares;
    @ManyToMany
    @JoinTable(name = "tb_servico_orcamento",
            joinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orcamento_id", referencedColumnName = "id"))
    private List<Orcamento> orcamentos;

    public Long getId() {
        return id;
    }

    public List<Auxiliar> getAuxiliares() {
        if(auxiliares == null) {
            auxiliares = new ArrayList<>();
        }

        return auxiliares;
    }

    public void setAuxiliares(List<Auxiliar> auxiliares) {
        this.auxiliares = auxiliares;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public Servico(Long id, Integer quantidadeDisponivel, Double valorMaoDeObra, Double valorTotal, String descricao, Date dtInicial, Date dtFinal) {
        this.id = id;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.valorMaoDeObra = valorMaoDeObra;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.auxiliares = new ArrayList<>();
    }

    public void adicionarAuxiliar(Auxiliar auxiliar) {
        if(auxiliar != null && !getAuxiliares().contains(auxiliar)) {
            getAuxiliares().add(auxiliar);

            if(!auxiliar.getServicos().contains(this)) {
                auxiliar.getServicos().add(this);
            }
        }
    }
}
