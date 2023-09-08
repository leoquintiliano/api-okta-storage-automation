package br.com.leadersofts.apioktastorage.estoque.dto;

import br.com.leadersofts.apioktastorage.veiculo.dto.VeiculoDTO;

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
public class EstoqueDTO {

    private Long id;

    private Long quantidade;

    private LocalDate dataEntrada;

    private Long diasNoEstoque;

    private float media;

    private String origem; // enum

    private String dono; // enum - fiat, andré, augusto

    private String marca;

    private String status; // enum - liberado,bloqueado,pré-venda,cliente

    private String estoque; // enum - Itajubá, São Lourenço, Cliente

    private List<VeiculoDTO> veiculos;

    private String observacoesOficina; // Observações gerais

    private String revisao;

    private String mecanica;

    private String polimento;

    private String pintura;

    private String funilaria;

    private String higienizacao;

    private String transferencia;

}
