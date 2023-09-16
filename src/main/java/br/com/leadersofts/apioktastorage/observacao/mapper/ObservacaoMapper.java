package br.com.leadersofts.apioktastorage.observacao.mapper;

import br.com.leadersofts.apioktastorage.observacao.domain.Observacao;
import br.com.leadersofts.apioktastorage.observacao.dto.ObservacaoDTO;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ObservacaoMapper {

    public Observacao getObservacao(ObservacaoDTO observacaoDTO) {

        if(Objects.nonNull(observacaoDTO)) {
            return Observacao.builder()
                    .id( Objects.nonNull(observacaoDTO.getId()) ? observacaoDTO.getId() : 0L)
                    .observacoesOficina( Objects.nonNull(observacaoDTO.getTransferencia()) ? observacaoDTO.getObservacoesOficina() : "")
                    .revisao( Objects.nonNull(observacaoDTO.getRevisao()) ? observacaoDTO.getRevisao() : "")
                    .mecanica( Objects.nonNull(observacaoDTO.getMecanica()) ? observacaoDTO.getMecanica() : "")
                    .polimento( Objects.nonNull(observacaoDTO.getPolimento()) ? observacaoDTO.getPolimento() : "")
                    .pintura( Objects.nonNull(observacaoDTO.getPintura()) ? observacaoDTO.getPintura() : "")
                    .funilaria( Objects.nonNull(observacaoDTO.getFunilaria()) ? observacaoDTO.getFunilaria() : "")
                    .higienizacao( Objects.nonNull(observacaoDTO.getHigienizacao()) ? observacaoDTO.getHigienizacao() : "")
                    .transferencia( Objects.nonNull(observacaoDTO.getTransferencia()) ? observacaoDTO.getTransferencia() : "" )
                    .build();
        }
        return new Observacao();
    }

    public ObservacaoDTO getObservacaoDTO(Observacao observacao) {

        if(Objects.nonNull(observacao)) {
            return ObservacaoDTO.builder()
                    .id( Objects.nonNull(observacao.getId()) ? observacao.getId() : 0L)
                    .observacoesOficina( Objects.nonNull(observacao.getTransferencia()) ? observacao.getObservacoesOficina() : "")
                    .revisao( Objects.nonNull(observacao.getRevisao()) ? observacao.getRevisao() : "")
                    .mecanica( Objects.nonNull(observacao.getMecanica()) ? observacao.getMecanica() : "")
                    .polimento( Objects.nonNull(observacao.getPolimento()) ? observacao.getPolimento() : "")
                    .pintura( Objects.nonNull(observacao.getPintura()) ? observacao.getPintura() : "")
                    .funilaria( Objects.nonNull(observacao.getFunilaria()) ? observacao.getFunilaria() : "")
                    .higienizacao( Objects.nonNull(observacao.getHigienizacao()) ? observacao.getHigienizacao() : "")
                    .transferencia( Objects.nonNull(observacao.getTransferencia()) ? observacao.getTransferencia() : "" )
                    .build();
        }
        return new ObservacaoDTO();
    }

    public List<ObservacaoDTO> getObservacoesList(Observacao observacao, List<ObservacaoDTO> observacaoDTOList) {
        var observacaoDTO = this.getObservacaoDTO(observacao);

        if(!observacaoDTOList.contains(observacaoDTO))
            observacaoDTOList.add(observacaoDTO);

        return observacaoDTOList;
    }

}
