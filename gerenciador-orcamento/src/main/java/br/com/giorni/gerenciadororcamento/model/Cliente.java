package br.com.giorni.gerenciadororcamento.model;

import br.com.giorni.gerenciadororcamento.service.dto.ClienteDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "tipo_cliente")
    private String tipoCliente;
    private String email;
    private String nome;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    @OneToMany(mappedBy = "cliente")
    private List<Orcamento> orcamentos;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    private String telefone;
}
