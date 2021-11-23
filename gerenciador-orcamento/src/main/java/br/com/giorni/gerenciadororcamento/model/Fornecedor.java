package br.com.giorni.gerenciadororcamento.model;


import br.com.giorni.gerenciadororcamento.service.dto.FornecedorDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
