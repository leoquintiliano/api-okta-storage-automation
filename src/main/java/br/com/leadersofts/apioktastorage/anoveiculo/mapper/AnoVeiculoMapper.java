package br.com.leadersofts.apioktastorage.anoveiculo.mapper;

import br.com.leadersofts.apioktastorage.anoveiculo.domain.AnoVeiculo;
import br.com.leadersofts.apioktastorage.anoveiculo.dto.AnoVeiculoDTO;
import br.com.leadersofts.apioktastorage.anoveiculo.pojo.AnoVeiculoPojo;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AnoVeiculoMapper {

    public AnoVeiculoDTO getAnoVeiculoDTO(AnoVeiculo anoVeiculo) {
        return AnoVeiculoDTO.builder()
                .id(Objects.nonNull(anoVeiculo.getId()) ? anoVeiculo.getId() : 0L)
                .codigo(Objects.nonNull(anoVeiculo.getCodigo()) ? anoVeiculo.getCodigo() : "")
                .nome(Objects.nonNull(anoVeiculo.getNome()) ? anoVeiculo.getNome() : "")
                .build();
    }

    public AnoVeiculoDTO getAnoVeiculoDTOFromPojo(AnoVeiculoPojo anoVeiculo) {
        return AnoVeiculoDTO.builder()
                .id(Objects.nonNull(anoVeiculo.getId()) ? anoVeiculo.getId() : 0L)
                .codigo(Objects.nonNull(anoVeiculo.getCodigo()) ? anoVeiculo.getCodigo() : "")
                .nome(Objects.nonNull(anoVeiculo.getNome()) ? anoVeiculo.getNome() : "")
                .build();
    }

    public AnoVeiculo getAnoVeiculoFromPojo(AnoVeiculoPojo anoVeiculoPojo) {
        return AnoVeiculo.builder()
                .id(Objects.nonNull(anoVeiculoPojo.getId()) ? anoVeiculoPojo.getId() : 0L)
                .codigo(Objects.nonNull(anoVeiculoPojo.getCodigo()) ? anoVeiculoPojo.getCodigo() : "")
                .nome(Objects.nonNull(anoVeiculoPojo.getNome()) ? anoVeiculoPojo.getNome() : "")
                .build();
    }

    public AnoVeiculo getAnoVeiculo(AnoVeiculoDTO anoVeiculo) {
        return AnoVeiculo.builder()
                .id(Objects.nonNull(anoVeiculo.getId()) ? anoVeiculo.getId() : 0L)
                .codigo(Objects.nonNull(anoVeiculo.getCodigo()) ? anoVeiculo.getCodigo() : "")
                .nome(Objects.nonNull(anoVeiculo.getNome()) ? anoVeiculo.getNome() : "")
                .build();
    }



}
