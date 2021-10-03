package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String numero;
    private String cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String estado;
    @ManyToMany
    @JoinTable(name = "tb_endereco_orcamento",
    joinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orcammento_id", referencedColumnName = "id"))
    private List<Orcamento> orcamentos;

    public List<Orcamento> getOrcamentos() {
        if (orcamentos == null){
            orcamentos = new ArrayList<>();
        }
        return orcamentos;
    }

    public EnderecoDTO toDto() { return new EnderecoDTO(this.id, this.numero, this.cep, this.cidade, this.bairro, this.logradouro, this.estado);}
}
