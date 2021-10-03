package br.com.giorni.gerenciadororcamento.service.dto;

public class EnderecoDTO {
    private Long id;
    private String numero;
    private String cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String estado;

    public EnderecoDTO(Long id, String numero, String cep, String cidade, String bairro, String logradouro, String estado) {
        this.id = id;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getEstado() {
        return estado;
    }
}
