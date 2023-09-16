package br.com.leadersofts.apioktastorage.observacao.domain;

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
@Table(name = "observacao")
public class Observacao {

    @Id
    @SequenceGenerator(name = "seq_observacao", sequenceName = "seq_observacao", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_observacao")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "obs_oficina")
    private String observacoesOficina; // Observações gerais

    @Column
    private String revisao;

    @Column
    private String mecanica;

    @Column
    private String polimento;

    @Column
    private String pintura;

    @Column
    private String funilaria;

    @Column
    private String higienizacao;

    @Column
    private String transferencia;

}
