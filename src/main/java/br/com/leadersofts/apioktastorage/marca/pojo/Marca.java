package br.com.leadersofts.apioktastorage.marca.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marca {

    private Long codigo;

    private String nome;

    private Long id;

}
