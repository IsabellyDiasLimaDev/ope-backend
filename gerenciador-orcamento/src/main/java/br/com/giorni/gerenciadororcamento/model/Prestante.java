package br.com.giorni.gerenciadororcamento.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Prestante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Usuario login;
    private String nome;
    private String telefone;


}
