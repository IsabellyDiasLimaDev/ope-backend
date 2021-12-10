package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Cliente;
import br.com.giorni.gerenciadororcamento.model.Endereco;
import br.com.giorni.gerenciadororcamento.model.Orcamento;
import br.com.giorni.gerenciadororcamento.service.dto.ClienteDTO;
import br.com.giorni.gerenciadororcamento.service.dto.EnderecoDTO;
import br.com.giorni.gerenciadororcamento.service.dto.OrcamentoDTO;
import br.com.giorni.gerenciadororcamento.service.response.ClienteSemOrcamentoResponse;
import br.com.giorni.gerenciadororcamento.service.response.EnderecoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteMapper {

    public static Cliente toEntity(ClienteDTO clienteDTO){
        List<Orcamento> orcamentos = new ArrayList<>();
        if (clienteDTO.getOrcamentos() != null) {
            orcamentos = OrcamentoMapper.listOrcamentoDtoToListOrcamento(clienteDTO.getOrcamentos());

            return Cliente
                    .builder()
                    .id(clienteDTO.getId())
                    .email(clienteDTO.getEmail())
                    .nome(clienteDTO.getNome())
                    .telefone(clienteDTO.getTelefone())
                    .cpfCnpj(clienteDTO.getCpfCnpj())
                    .tipoCliente(clienteDTO.getTipoCliente())
                    .endereco(Endereco
                            .builder()
                            .numero(clienteDTO.getEndereco().getNumero())
                            .logradouro(clienteDTO.getEndereco().getLogradouro())
                            .bairro(clienteDTO.getEndereco().getBairro())
                            .cep(clienteDTO.getEndereco().getCep())
                            .cidade(clienteDTO.getEndereco().getCidade())
                            .estado(clienteDTO.getEndereco().getEstado())
                            .id(clienteDTO.getEndereco().getId())
                            .build())
                    .orcamentos(orcamentos)
                    .build();
        }

        return Cliente
                .builder()
                .id(clienteDTO.getId())
                .email(clienteDTO.getEmail())
                .nome(clienteDTO.getNome())
                .telefone(clienteDTO.getTelefone())
                .cpfCnpj(clienteDTO.getCpfCnpj())
                .tipoCliente(clienteDTO.getTipoCliente())
                .endereco(Endereco
                        .builder()
                        .numero(clienteDTO.getEndereco().getNumero())
                        .logradouro(clienteDTO.getEndereco().getLogradouro())
                        .bairro(clienteDTO.getEndereco().getBairro())
                        .cep(clienteDTO.getEndereco().getCep())
                        .cidade(clienteDTO.getEndereco().getCidade())
                        .estado(clienteDTO.getEndereco().getEstado())
                        .id(clienteDTO.getEndereco().getId())
                        .build())
                .build();
    }

    public static ClienteDTO toDto(Cliente cliente) {
        List<OrcamentoDTO> orcamentos = new ArrayList<>();
        if (cliente.getOrcamentos() != null){
            orcamentos = OrcamentoMapper.listOrcamentoToListOrcamentoDto(cliente.getOrcamentos());
        }
        return ClienteDTO
                .builder()
                .id(cliente.getId())
                .email(cliente.getEmail())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .cpfCnpj(cliente.getCpfCnpj())
                .tipoCliente(cliente.getTipoCliente())
                .orcamentos(orcamentos)
                .endereco(EnderecoDTO
                        .builder()
                        .numero(cliente.getEndereco().getNumero())
                        .bairro(cliente.getEndereco().getBairro())
                        .cep(cliente.getEndereco().getCep())
                        .cidade(cliente.getEndereco().getCidade())
                        .estado(cliente.getEndereco().getEstado())
                        .id(cliente.getEndereco().getId())
                        .build())
                .build();
    }

    public static ClienteSemOrcamentoResponse toResponseSemOrcamento(Cliente cliente){
        return ClienteSemOrcamentoResponse
                .builder()
                .id(cliente.getId())
                .cpfCnpj(cliente.getCpfCnpj())
                .email(cliente.getEmail())
                .endereco(EnderecoResponse
                        .builder()
                        .id(cliente.getEndereco().getId())
                        .bairro(cliente.getEndereco().getBairro())
                        .cep(cliente.getEndereco().getCep())
                        .cidade(cliente.getEndereco().getCidade())
                        .logradouro(cliente.getEndereco().getLogradouro())
                        .estado(cliente.getEndereco().getEstado())
                        .numero(cliente.getEndereco().getNumero())
                        .build())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .tipoCliente(cliente.getTipoCliente())
                .build();
    }
}
