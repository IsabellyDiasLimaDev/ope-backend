package br.com.giorni.gerenciadororcamento.service.dto;

import br.com.giorni.gerenciadororcamento.model.Endereco;

public class EmpresaDTO {
    private Long id;
    private String nomeFantasia;
    private Endereco endereco;

    public EmpresaDTO(Long id, String nomeFantasia, Endereco endereco) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
