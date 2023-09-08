package br.com.leadersofts.apioktastorage.observacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservacaoDTO {

    private Long id;

    private String observacoesOficina; // Observações gerais

    private String revisao;

    private String mecanica;

    private String polimento;

    private String pintura;

    private String funilaria;

    private String higienizacao;

    private String transferencia;

}
