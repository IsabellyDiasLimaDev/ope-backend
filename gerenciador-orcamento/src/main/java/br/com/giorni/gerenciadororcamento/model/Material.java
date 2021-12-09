package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.MaterialDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double preco;
    private String tipo;
    private String categoria;
    @Column(name = "quantidade_disponivel")
    @JsonProperty("quantidade_disponivel")
    private Integer quantidadeDisponivel;
    private String descricao;
    private String cor;
    @ManyToMany
    @JoinTable(
            name="tb_material_fornecedor",
            joinColumns = @JoinColumn(name="material_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="fornecedor_id", referencedColumnName = "id")
    )
    private List<Fornecedor> fornecedores;


    public List<Fornecedor> getFornecedores() {
        if(fornecedores == null) {
            fornecedores = new ArrayList<>();
        }
        return fornecedores;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        if(fornecedor != null && !getFornecedores().contains(fornecedor)) {
            getFornecedores().add(fornecedor);

            if(!fornecedor.getMateriais().contains(this)) {
                fornecedor.getMateriais().add(this);
            }
        }
    }
}
