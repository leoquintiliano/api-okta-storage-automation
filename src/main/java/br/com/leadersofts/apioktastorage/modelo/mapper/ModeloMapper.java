package br.com.leadersofts.apioktastorage.modelo.mapper;

import br.com.leadersofts.apioktastorage.modelo.domain.Modelo;
import br.com.leadersofts.apioktastorage.modelo.dto.ModeloDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ModeloMapper {

    public ModeloDTO getModeloDTO(Modelo modelo) {
        if(!Objects.isNull(modelo)) {
            return ModeloDTO.builder()
                    .id(Objects.nonNull(modelo.getId()) ? modelo.getId() : 0L)
                    .codigo(Objects.nonNull(modelo.getCodigo()) ? modelo.getCodigo() : 0L)
                    .nome(Objects.nonNull(modelo.getNome()) ? modelo.getNome() : "" )
                    .codigoMarca(Objects.nonNull(modelo.getCodigoMarca()) ? modelo.getCodigoMarca() : 0L)
                    .tipoVeiculo(Objects.nonNull(modelo.getTipoVeiculo()) ? modelo.getTipoVeiculo() : "")
                    .build();
        }
        return new ModeloDTO();
    }

    public Modelo getModelo(ModeloDTO modeloDTO) {
        if(!Objects.isNull(modeloDTO)) {
            return Modelo.builder()
                    .id(Objects.nonNull(modeloDTO.getId()) ? modeloDTO.getId() : 0L)
                    .codigo(Objects.nonNull(modeloDTO.getCodigo()) ? modeloDTO.getCodigo() : 0L)
                    .nome(Objects.nonNull(modeloDTO.getNome() ) ? modeloDTO.getNome() : "" )
                    .codigoMarca(Objects.nonNull(modeloDTO.getCodigoMarca()) ? modeloDTO.getCodigoMarca() : 0L)
                    .tipoVeiculo(Objects.nonNull(modeloDTO.getTipoVeiculo()) ? modeloDTO.getTipoVeiculo() : "")
                    .build();
        }
        return new Modelo();
    }

}
