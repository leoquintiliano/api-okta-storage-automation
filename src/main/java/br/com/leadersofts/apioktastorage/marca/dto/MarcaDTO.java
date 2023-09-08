package br.com.leadersofts.apioktastorage.marca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaDTO {

    private Long id;

    private Long codigo;

    private String nome;

    private String tipoVeiculo;

}
