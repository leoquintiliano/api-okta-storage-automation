package br.com.leadersofts.apioktastorage.veiculo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {

    private Long tipoVeiculo;

    private Float valor;

    private String marca;

    private String modelo;

    private Long anoModelo;

    private String combustivel;

    private String codigoFipe;

    private String mesReferencia;

    private String siglaCombustivel;

}