package br.com.leadersofts.apioktastorage.anoveiculo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnoVeiculoPojo {

    private Long id;

    private String codigo;

    private String nome;

}
