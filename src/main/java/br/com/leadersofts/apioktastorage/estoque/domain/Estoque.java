package br.com.leadersofts.apioktastorage.estoque.domain;

import br.com.leadersofts.apioktastorage.observacao.domain.Observacao;
import br.com.leadersofts.apioktastorage.veiculo.domain.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    @SequenceGenerator(name = "seq_estoque", sequenceName = "seq_estoque", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estoque")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Long quantidade;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "dias_no_estoque")
    private Long diasNoEstoque;

    @Column
    private float media;

    @Column
    private String origem;

    @Column
    private String dono;

    @Column
    private String marca;

    @Column
    private String status;

    @Column(name = "local_estoque")
    private String estoque;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Veiculo> veiculos;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true ,fetch = FetchType.LAZY)
    private Observacao observacao;

}
