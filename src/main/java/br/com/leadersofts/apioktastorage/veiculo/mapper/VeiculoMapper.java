package br.com.leadersofts.apioktastorage.veiculo.mapper;

import br.com.leadersofts.apioktastorage.veiculo.domain.Veiculo;
import br.com.leadersofts.apioktastorage.veiculo.dto.VeiculoDTO;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VeiculoMapper {

    public VeiculoDTO getVeiculoDTO(Veiculo veiculo) {
        if(Objects.nonNull(veiculo)) {
            return VeiculoDTO.builder()
                    .id(!Objects.isNull(veiculo.getId()) ? veiculo.getId() : 0L)
                    .marca(!Objects.isNull(veiculo.getMarca()) ? veiculo.getMarca() : "")
                    .nome(!Objects.isNull(veiculo.getNome()) ? veiculo.getNome() : "")
                    .kilometragem(!Objects.isNull(veiculo.getKilometragem()) ? veiculo.getKilometragem() : 0L)
                    .cor(!Objects.isNull(veiculo.getCor()) ? veiculo.getCor() : "")
                    .anoModelo(!Objects.isNull(veiculo.getAnoModelo()) ? veiculo.getAnoModelo() : "")
                    .placa(!Objects.isNull(veiculo.getPlaca()) ? veiculo.getPlaca() : "")
                    .opcionais(!Objects.isNull(veiculo.getOpcionais()) ? veiculo.getOpcionais() : "")
                    .valor(!Objects.isNull(veiculo.getValor()) ? veiculo.getValor() : 0F)
                    .modelo(!Objects.isNull(veiculo.getModelo()) ? veiculo.getModelo() : "" )
                    .tipoVeiculo(!Objects.isNull(veiculo.getTipoVeiculo()) ? veiculo.getTipoVeiculo() : 0L)
                    .codigoFipe(!Objects.isNull(veiculo.getCodigoFipe()) ? veiculo.getCodigoFipe() : "")
                    .combustivel(!Objects.isNull(veiculo.getCombustivel()) ? veiculo.getCombustivel() : "")
                    .siglaCombustivel(!Objects.isNull(veiculo.getSiglaCombustivel()) ? veiculo.getSiglaCombustivel() : "")
                    .codigoAno(!Objects.isNull(veiculo.getCodigoAno()) ? veiculo.getCodigoAno() : "")
                    .build();


//                    .idMarca(!Objects.isNull(veiculo.getIdMarca()) ? veiculo.getIdMarca() : 0L)
//                    .modelo(!Objects.isNull(veiculo.getModelo()) ? veiculo.getModelo() : "" )
//                    .preco(!Objects.isNull(veiculo.getPreco()) ? veiculo.getPreco() : 0F)
//                    .tipo(!Objects.isNull(veiculo.getTipo()) ? veiculo.getTipo() : 0L)
//                    .fipeCodigo(!Objects.isNull(veiculo.getFipeCodigo()) ? veiculo.getFipeCodigo() : "")
//                    .idModeloAno(!Objects.isNull(veiculo.getIdModeloAno()) ? veiculo.getIdModeloAno() : "")
//                    .combustivel(!Objects.isNull(veiculo.getCombustivel()) ? veiculo.getCombustivel() : "")
//                    .ano(!Objects.isNull(veiculo.getAno()) ? veiculo.getAno() : 0L)
//                    .idModelo(!Objects.isNull(veiculo.getIdModelo()) ? veiculo.getIdModelo() : 0L)
//                    .build();
        }
        return new VeiculoDTO();
    }

    public Veiculo getVeiculo(VeiculoDTO veiculoDTO) {

        if(Objects.nonNull(veiculoDTO)) {
            return Veiculo.builder()
                    .nome(!Objects.isNull(veiculoDTO.getNome()) ? veiculoDTO.getNome() : "")
                    .marca(!Objects.isNull(veiculoDTO.getMarca()) ? veiculoDTO.getMarca() : "")
                    .placa(!Objects.isNull(veiculoDTO.getPlaca()) ? veiculoDTO.getPlaca() : "")
                    .kilometragem(!Objects.isNull(veiculoDTO.getKilometragem()) ? veiculoDTO.getKilometragem() : 0L)
                    .cor(!Objects.isNull(veiculoDTO.getCor()) ? veiculoDTO.getCor() : "")
                    .anoModelo(!Objects.isNull(veiculoDTO.getAnoModelo()) ? veiculoDTO.getAnoModelo() : "")
                    .opcionais(!Objects.isNull(veiculoDTO.getOpcionais()) ? veiculoDTO.getOpcionais() : "")
                    .valor(!Objects.isNull(veiculoDTO.getValor()) ? veiculoDTO.getValor() : 0F)
                    .modelo(!Objects.isNull(veiculoDTO.getModelo()) ? veiculoDTO.getModelo() : "" )
                    .tipoVeiculo(!Objects.isNull(veiculoDTO.getTipoVeiculo()) ? veiculoDTO.getTipoVeiculo() : 0L)
                    .codigoFipe(!Objects.isNull(veiculoDTO.getCodigoFipe()) ? veiculoDTO.getCodigoFipe() : "")
                    .combustivel(!Objects.isNull(veiculoDTO.getCombustivel()) ? veiculoDTO.getCombustivel() : "")
                    .siglaCombustivel(!Objects.isNull(veiculoDTO.getSiglaCombustivel()) ? veiculoDTO.getSiglaCombustivel() : "")
                    .codigoAno(!Objects.isNull(veiculoDTO.getCodigoAno()) ? veiculoDTO.getCodigoAno() : "")
                    .build();
        }

        return new Veiculo();
    }

    public Veiculo convertPojoToModel(br.com.leadersofts.apioktastorage.veiculo.pojo.Veiculo veiculoResponse) {

        return Veiculo.builder()
                .nome(!Objects.isNull(veiculoResponse.getModelo()) ? veiculoResponse.getModelo() : "")
                .marca(!Objects.isNull(veiculoResponse.getMarca()) ? veiculoResponse.getMarca() : "")
                .anoModelo(!Objects.isNull(veiculoResponse.getAnoModelo()) ? veiculoResponse.getAnoModelo().toString() : "")
                .mesReferencia(!Objects.isNull(veiculoResponse.getMesReferencia()) ? veiculoResponse.getMesReferencia() : "")
                .modelo(!Objects.isNull(veiculoResponse.getModelo()) ? this.getModeloVeiculo(veiculoResponse.getModelo()) : "" )
                .valor(!Objects.isNull(veiculoResponse.getValor()) ? veiculoResponse.getValor() : 0F)
                .tipoVeiculo(!Objects.isNull(veiculoResponse.getTipoVeiculo() ) ? veiculoResponse.getTipoVeiculo() : 0L)
                .codigoFipe(!Objects.isNull(veiculoResponse.getCodigoFipe()) ? veiculoResponse.getCodigoFipe() : "")
                .siglaCombustivel(!Objects.isNull(veiculoResponse.getSiglaCombustivel()) ? veiculoResponse.getSiglaCombustivel() : "")
                .combustivel(!Objects.isNull(veiculoResponse.getCombustivel()) ? veiculoResponse.getCombustivel() : "")
                .build();
    }

    public VeiculoDTO convertPojoToDTO(br.com.leadersofts.apioktastorage.veiculo.pojo.Veiculo veiculoResponse, String codigoAno) {

        return VeiculoDTO.builder()
                .nome(!Objects.isNull(veiculoResponse.getModelo()) ? veiculoResponse.getModelo() : "")
                .marca(!Objects.isNull(veiculoResponse.getMarca()) ? veiculoResponse.getMarca() : "")
                .anoModelo(!Objects.isNull(veiculoResponse.getAnoModelo()) ? veiculoResponse.getAnoModelo().toString() : "")
                .mesReferencia(!Objects.isNull(veiculoResponse.getMesReferencia()) ? veiculoResponse.getMesReferencia() : "")
                .modelo(!Objects.isNull(veiculoResponse.getModelo()) ? this.getModeloVeiculo(veiculoResponse.getModelo()) : "" )
                .valor(!Objects.isNull(veiculoResponse.getValor()) ? veiculoResponse.getValor() : 0F)
                .tipoVeiculo(!Objects.isNull(veiculoResponse.getTipoVeiculo() ) ? veiculoResponse.getTipoVeiculo() : 0L)
                .codigoFipe(!Objects.isNull(veiculoResponse.getCodigoFipe()) ? veiculoResponse.getCodigoFipe() : "")
                .siglaCombustivel(!Objects.isNull(veiculoResponse.getSiglaCombustivel()) ? veiculoResponse.getSiglaCombustivel() : "")
                .combustivel(!Objects.isNull(veiculoResponse.getCombustivel()) ? veiculoResponse.getCombustivel() : "")
                .codigoAno(!Objects.isNull(codigoAno) ? codigoAno : "")
                .build();
    }

    private String getModeloVeiculo(String modeloVeiculo) {
        var modelo = modeloVeiculo.split(" ");
        return modelo[0];
    }

}
