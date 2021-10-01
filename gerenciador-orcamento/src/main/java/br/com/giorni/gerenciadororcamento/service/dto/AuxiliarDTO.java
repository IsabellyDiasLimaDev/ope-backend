package br.com.giorni.gerenciadororcamento.service.dto;

import javax.persistence.Column;

public class AuxiliarDTO {
    private Long id;
    private String telefone;
    private String nome;
    private String tipoServico;
    private boolean disponbibilidade;
    private String email;

    public AuxiliarDTO(Long id, String telefone, String nome, String tipoServico, boolean disponibilidade, String email) {
        this.id = id;
        this.telefone = telefone;
        this.nome = nome;
        this.tipoServico = tipoServico;
        this.disponbibilidade = disponibilidade;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public boolean isDisponbibilidade() {
        return disponbibilidade;
    }

    public String getEmail() {
        return email;
    }
}
