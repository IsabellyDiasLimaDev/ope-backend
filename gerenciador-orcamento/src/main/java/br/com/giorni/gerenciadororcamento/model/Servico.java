package br.com.giorni.gerenciadororcamento.model;

import javax.persistence.*;
import java.util.Date;
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
    @OneToMany
    Set<MaterialServico> materialServicos;
    @OneToMany
    Set<ServicoAuxiliar> servicoAuxiliar;
    @OneToMany
    Set<ServicoOrcamento> servicoOrcamento;

    public Long getId() {
        return id;
    }
}
