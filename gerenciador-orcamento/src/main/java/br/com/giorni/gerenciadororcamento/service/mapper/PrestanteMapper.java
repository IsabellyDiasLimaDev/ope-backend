package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Prestante;
import br.com.giorni.gerenciadororcamento.service.dto.PrestanteDTO;
import br.com.giorni.gerenciadororcamento.service.response.PrestanteResponse;
import br.com.giorni.gerenciadororcamento.service.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class PrestanteMapper {

    public static Prestante toEntity(PrestanteDTO prestanteDTO){
        return Prestante
                .builder()
                .id(prestanteDTO.getId())
                .login(UsuarioMapper.toEntity(prestanteDTO.getLogin()))
                .nome(prestanteDTO.getNome())
                .empresa(EmpresaMapper.toEntity(prestanteDTO.getEmpresa()))
                .telefone(prestanteDTO.getTelefone())
                .build();
    }

    public static PrestanteDTO toDto(Prestante prestante){

        return PrestanteDTO.builder()
                .id(prestante.getId())
                .login(UsuarioMapper.toDto(prestante.getLogin()))
                .nome(prestante.getNome())
                .empresa(EmpresaMapper.toDto(prestante.getEmpresa()))
                .telefone(prestante.getTelefone())
                .build();
    }

    public static PrestanteResponse toResponse(Prestante prestante){

        return PrestanteResponse.builder()
                .id(prestante.getId())
                .login(UsuarioMapper.toResponse(prestante.getLogin()))
                .nome(prestante.getNome())
                .empresa(EmpresaMapper.toResponse(prestante.getEmpresa()))
                .telefone(prestante.getTelefone())
                .build();
    }

}
