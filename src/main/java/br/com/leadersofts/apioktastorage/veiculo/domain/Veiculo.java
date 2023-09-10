package br.com.leadersofts.apioktastorage.veiculo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Veiculo {

    // Campos personalizados
    @Id
    @SequenceGenerator(name = "seq_veiculo", sequenceName = "seq_veiculo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String placa;

    @Column
    private String anoModelo;

    @Column
    private float kilometragem;

    @Column
    private String cor;

    @Column
    private String opcionais;

    // Campos da api da tabela FIpe
    @Column
    private Long tipoVeiculo;

    @Column(name = "codigo_fipe")
    private String codigoFipe;

    @Column(name = "mes_referencia")
    private String mesReferencia;

    @Column
    private String modelo;

    @Column
    private String combustivel;

    @Column
    private String siglaCombustivel;

    @Column
    private Float valor;

    @Column
    private String marca;

    @Column
    private String nome;

    @Column
    private String codigoAno;

}
