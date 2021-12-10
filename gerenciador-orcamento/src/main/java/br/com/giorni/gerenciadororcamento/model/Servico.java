package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoSemMaterialDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_servico")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "valor_mao_de_obra")
    private Double valorMaoDeObra;

    @Column(name = "valor_total")
    private Double valorTotal;

    private String descricao;
    @Column(name = "dt_inicial")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dtInicial;

    @Column(name = "dt_final")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dtFinal;

    @ManyToMany
    @JoinTable(name = "tb_servico_auxiliar",
            joinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auxiliar_id", referencedColumnName = "id"))
    private List<Auxiliar> auxiliares;

    @ManyToMany(mappedBy = "servicos")
    private List<Orcamento> orcamentos;


    @OneToMany(mappedBy = "servico", cascade = CascadeType.PERSIST)
    private List<MaterialServico> materiais = new ArrayList<>();

    public Servico(Long id, Double valorMaoDeObra, Double valorTotal, String descricao, LocalDate dtInicial, LocalDate dtFinal, List<Auxiliar> auxiliares, List<MaterialServico> materiais) {
        this.id = id;
        this.valorMaoDeObra = valorMaoDeObra;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dtInicial = dtInicial;
        this.dtFinal = dtFinal;
        this.auxiliares = auxiliares;
        this.orcamentos = new ArrayList<>();
        this.materiais = materiais;
    }

    public List<Auxiliar> getAuxiliares() {
        if (auxiliares == null) {
            auxiliares = new ArrayList<>();
        }

        return auxiliares;
    }

    public void adicionarAuxiliar(Auxiliar auxiliar) {
        if (auxiliar != null && !getAuxiliares().contains(auxiliar)) {
            getAuxiliares().add(auxiliar);

            if (!auxiliar.getServicos().contains(this)) {
                auxiliar.getServicos().add(this);
            }
        }
    }

    public List<Orcamento> getOrcamentos() {
        if(orcamentos == null) {
            orcamentos = new ArrayList<>();
        }
        return orcamentos;
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        if(orcamento != null && !getOrcamentos().contains(orcamento)) {
            getOrcamentos().add(orcamento);

            if(!orcamento.getServicos().contains(this)) {
                orcamento.getServicos().add(this);
            }
        }
    }
}
