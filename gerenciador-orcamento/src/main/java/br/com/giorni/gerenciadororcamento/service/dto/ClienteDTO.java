package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Endereco;

public class ClienteDTO {
    private Long id;
    private String tipoCliente;
    private String email;
    private String nome;
    private Endereco endereco;
    private String cpfCnpj;
    private String telefone;

    public ClienteDTO(Long id, String tipoCliente, String email, String nome, Endereco endereco, String cpfCnpj, String telefone) {
        this.id = id;
        this.tipoCliente = tipoCliente;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }
}
