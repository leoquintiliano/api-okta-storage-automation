package br.com.leadersofts.apioktastorage.veiculo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeiculoDTO {

    private Long id;

    private String nome;

    private String placa;

    private float kilometragem;

    private String cor;

    private String opcionais;

    private String anoModelo;

    //Campos da Api gratuita da Fipe
    private Long tipoVeiculo;

    private Float valor;

    private String marca;

    private String modelo;

    private String combustivel;

    private String codigoFipe;

    private String mesReferencia;

    private String siglaCombustivel;

    private String codigoAno;


    // Campos da api da tabela FIpe
//    private Long tipo;
//
//    private String fipeCodigo;
//
//    private Long idMarca;
//
//    private String idModeloAno;
//
//    private Long idModelo;
//
//    private String modelo;
//
//    private Long ano;
//
//    private String combustivel;
//
//    private Float preco;
//
//    private String name;

}
