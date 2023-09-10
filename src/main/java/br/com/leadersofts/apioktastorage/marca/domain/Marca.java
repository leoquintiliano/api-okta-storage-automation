package br.com.leadersofts.apioktastorage.marca.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Marca {

    @Id
    @SequenceGenerator(name = "seq_marca", sequenceName = "seq_marca", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Long codigo;

    @Column
    private String nome;

    @Column
    private String tipoVeiculo;

}
