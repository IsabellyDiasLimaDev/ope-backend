package br.com.giorni.gerenciadororcamento.model;


import javax.persistence.*;
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
    @OneToMany
    Set<FornecedorMaterial> fornecedorMateriais;

    public Long getId() {
        return id;
    }
}
