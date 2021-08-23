package br.com.giorni.gerenciadororcamento.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @ManyToMany
    @JoinTable(
            name="tb_fornecedor_material",
            joinColumns = @JoinColumn(name="fornecedor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="material_id", referencedColumnName = "id")
    )
    private List<Material> materiais;

    public Fornecedor(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.materiais = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }
}
