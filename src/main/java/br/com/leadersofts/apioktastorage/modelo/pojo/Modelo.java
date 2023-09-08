package br.com.leadersofts.apioktastorage.modelo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Modelo {

    private String codigo;

    private String nome;

}
