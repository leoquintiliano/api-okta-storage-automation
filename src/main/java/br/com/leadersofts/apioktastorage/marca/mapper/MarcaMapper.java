package br.com.leadersofts.apioktastorage.marca.mapper;

import br.com.leadersofts.apioktastorage.marca.domain.Marca;
import br.com.leadersofts.apioktastorage.marca.dto.MarcaDTO;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MarcaMapper {

    public MarcaDTO getMarcaDTO(Marca marca) {
        if(!Objects.isNull(marca)) {
            return MarcaDTO.builder()
                    .id(Objects.nonNull(marca.getId()) ? marca.getId() : 0L)
                    .codigo(Objects.nonNull(marca.getCodigo()) ? marca.getCodigo() : 0L)
                    .nome(Objects.nonNull(marca.getNome()) ? marca.getNome() : "" )
                    .tipoVeiculo(Objects.nonNull(marca.getTipoVeiculo()) ? marca.getTipoVeiculo() : "")
                    .build();
        }

        return new MarcaDTO();
    }

    public Marca getMarca(MarcaDTO marcaDTO) {
        if(!Objects.isNull(marcaDTO)) {
            return Marca.builder()
                    .id(Objects.nonNull(marcaDTO.getId()) ? marcaDTO.getId() : 0L)
                    .codigo(Objects.nonNull(marcaDTO.getCodigo()) ? marcaDTO.getCodigo() : 0L)
                    .nome(Objects.nonNull(marcaDTO.getNome() ) ? marcaDTO.getNome() : "" )
                    .tipoVeiculo(Objects.nonNull(marcaDTO.getTipoVeiculo()) ? marcaDTO.getTipoVeiculo() : "")
                    .build();
        }

        return new Marca();
    }

    public Marca getMarcaFromPOJO(br.com.leadersofts.apioktastorage.marca.pojo.Marca marca) {
        if(!Objects.isNull(marca)) {
            return Marca.builder()
                    .id(Objects.nonNull(marca.getId()) ? marca.getId() : 0L)
                    .codigo(Objects.nonNull(marca.getCodigo()) ? marca.getCodigo() : 0L)
                    .nome(Objects.nonNull(marca.getNome() ) ? marca.getNome() : "" )
                    .build();
        }
        return new Marca();
    }
}
