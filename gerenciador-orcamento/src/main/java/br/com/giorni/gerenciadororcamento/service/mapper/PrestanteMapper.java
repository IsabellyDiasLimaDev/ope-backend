package br.com.giorni.gerenciadororcamento.service.mapper;

import br.com.giorni.gerenciadororcamento.model.Prestante;
import br.com.giorni.gerenciadororcamento.service.dto.PrestanteDTO;
import org.springframework.stereotype.Component;

@Component
public class PrestanteMapper {

    public static Prestante toEntity(PrestanteDTO prestanteDTO){
        return Prestante
                .builder()
                .id(prestanteDTO.getId())
                .build();
    }

}
