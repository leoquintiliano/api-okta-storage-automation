package br.com.leadersofts.apioktastorage.anoveiculo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class AnoVeiculo {

    @Id
    @SequenceGenerator(name = "seq_ano_veiculo", sequenceName = "seq_ano_veiculo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ano_veiculo")
    @Column(name = "id", nullable = false)
    private Long id;

    private String codigo;

    private String nome;

}
