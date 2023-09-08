package br.com.leadersofts.apioktastorage.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeloDTO {

    private Long id;

    private Long codigo;

    private String nome;

    private Long codigoMarca;

    private String tipoVeiculo;

}
