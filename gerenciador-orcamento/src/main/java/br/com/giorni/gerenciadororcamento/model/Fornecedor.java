package br.com.giorni.gerenciadororcamento.model;


import br.com.giorni.gerenciadororcamento.service.dto.FornecedorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany(mappedBy = "fornecedores")
    private List<Material> materiais;

    public void adicionarMaterial(Material material) {
        if(material != null && !getMateriais().contains(material)) {
            getMateriais().add(material);

            if(!material.getFornecedores().contains(this)) {
                material.getFornecedores().add(this);
            }
        }
    }

    public List<Material> getMateriais() {
        if(materiais == null) {
            materiais = new ArrayList<>();
        }
        return materiais;
    }
}
