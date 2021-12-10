package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Empresa;
import br.com.giorni.gerenciadororcamento.model.Endereco;
import br.com.giorni.gerenciadororcamento.model.Prestante;
import br.com.giorni.gerenciadororcamento.service.dto.EmpresaDTO;
import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.PrestanteDTO;
import br.com.giorni.gerenciadororcamento.service.response.EmpresaResponse;
import br.com.giorni.gerenciadororcamento.service.response.EnderecoResponse;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {

    public static Empresa toEntity(EmpresaDTO empresaDTO){
        return Empresa
                .builder()
                .id(empresaDTO.getId())
                .nomeFantasia(empresaDTO.getNomeFantasia())
                .endereco(Endereco
                        .builder()
                        .numero(empresaDTO.getEndereco().getNumero())
                        .logradouro(empresaDTO.getEndereco().getLogradouro())
                        .bairro(empresaDTO.getEndereco().getBairro())
                        .cep(empresaDTO.getEndereco().getCep())
                        .cidade(empresaDTO.getEndereco().getCidade())
                        .estado(empresaDTO.getEndereco().getEstado())
                        .id(empresaDTO.getEndereco().getId())
                        .build())
                .build();
    }

    public static EmpresaDTO toDto (Empresa empresa){

        return EmpresaDTO.builder()
                .id(empresa.getId())
                .nomeFantasia(empresa.getNomeFantasia())
                .endereco(EnderecoDTO
                        .builder()
                        .numero(empresa.getEndereco().getNumero())
                        .bairro(empresa.getEndereco().getBairro())
                        .cep(empresa.getEndereco().getCep())
                        .cidade(empresa.getEndereco().getCidade())
                        .estado(empresa.getEndereco().getEstado())
                        .id(empresa.getEndereco().getId())
                        .build())
                .build();
    }

    public static EmpresaResponse toResponse (Empresa empresa){

        return EmpresaResponse.builder()
                .id(empresa.getId())
                .nomeFantasia(empresa.getNomeFantasia())
                .endereco(EnderecoResponse
                        .builder()
                        .id(empresa.getEndereco().getId())
                        .bairro(empresa.getEndereco().getBairro())
                        .cep(empresa.getEndereco().getCep())
                        .cidade(empresa.getEndereco().getCidade())
                        .logradouro(empresa.getEndereco().getLogradouro())
                        .estado(empresa.getEndereco().getEstado())
                        .numero(empresa.getEndereco().getNumero())
                        .build())
                .build();
    }


}
