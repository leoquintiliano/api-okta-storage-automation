package br.com.leadersofts.apioktastorage.modelo.domain;

//import jakarta.persistence.*;
import jakarta.persistence.*;
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
public class Modelo {

    @Id
    @SequenceGenerator(name = "seq_modelo", sequenceName = "seq_modelo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_modelo")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Long codigo;

    @Column
    private String nome;

    @Column
    private Long codigoMarca;

    @Column
    private String tipoVeiculo;

}
