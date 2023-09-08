package br.com.leadersofts.apioktastorage.anoveiculo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnoVeiculoDTO {

    private Long id;

    private String codigo;

    private String nome;

}
