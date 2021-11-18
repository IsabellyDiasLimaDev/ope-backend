package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.MaterialServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.ServicoSemMaterialDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "tb_servico")
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
    @ManyToMany
    @JoinTable(name = "tb_servico_orcamento",
            joinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orcamento_id", referencedColumnName = "id"))
    private List<Orcamento> orcamentos;

    //TODO Ajustar para relacionar Serviço com Material
    @OneToMany(mappedBy = "servico", cascade = CascadeType.PERSIST)
    private List<MaterialServico> materiais = new ArrayList<>();

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

    public ServicoDTO toDto() {
        var materialDTO = materiais.stream().map(MaterialServico::toDto).collect(Collectors.toList());
        var orcamentoDTO = orcamentos.stream().map(Orcamento::toDto).collect(Collectors.toList());
        var auxiliarDTO = auxiliares.stream().map(Auxiliar::toDto).collect(Collectors.toList());
        return new ServicoDTO(this.id, this.valorMaoDeObra, this.valorTotal, this.descricao, this.dtInicial, this.dtFinal, auxiliarDTO, orcamentoDTO,materialDTO);
    }

    public ServicoSemMaterialDTO toDtoSemMaterial() {
        var auxiliarDTO = auxiliares.stream().map(Auxiliar::toDto).collect(Collectors.toList());
        return new ServicoSemMaterialDTO(this.id, this.valorMaoDeObra, this.valorTotal, this.descricao, this.dtInicial, this.dtFinal, auxiliarDTO);
    }
}
