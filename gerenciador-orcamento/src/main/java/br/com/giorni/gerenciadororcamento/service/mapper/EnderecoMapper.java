package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Endereco;
import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
import br.com.giorni.gerenciadororcamento.service.response.EnderecoResponse;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public static Endereco toEntity(EnderecoDTO enderecoDTO){
        return Endereco
                .builder()
                .id(enderecoDTO.getId())
                .numero(enderecoDTO.getNumero())
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .bairro(enderecoDTO.getBairro())
                .logradouro(enderecoDTO.getLogradouro())
                .estado((enderecoDTO.getEstado()))
                .build();
    }

    public static EnderecoDTO toDto(Endereco endereco){

        return EnderecoDTO.builder()
                .id(endereco.getId())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .bairro(endereco.getBairro())
                .logradouro(endereco.getLogradouro())
                .estado(endereco.getEstado())
                .build();
    }

    public static EnderecoResponse toResponse(Endereco endereco) {

        return EnderecoResponse.builder()
                .id(endereco.getId())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .bairro(endereco.getBairro())
                .logradouro(endereco.getLogradouro())
                .estado(endereco.getEstado())
                .build();
    }

}
