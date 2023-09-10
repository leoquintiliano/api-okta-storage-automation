package br.com.leadersofts.apioktastorage.observacao.service;

import br.com.leadersofts.apioktastorage.observacao.domain.Observacao;
import br.com.leadersofts.apioktastorage.observacao.dto.ObservacaoDTO;
import br.com.leadersofts.apioktastorage.observacao.mapper.ObservacaoMapper;
import br.com.leadersofts.apioktastorage.observacao.repository.ObservacaoRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObservacaoService {

    @Autowired
    private ObservacaoRepository observacaoRepository;

    @Autowired
    private ObservacaoMapper observacaoMapper;

    public List<ObservacaoDTO> findAll() {

        var response = this.observacaoRepository.findAll();
        List<ObservacaoDTO> observacaoDTOList = new ArrayList<>();
        StreamSupport.stream(response.spliterator(), false).forEach(obs -> this.observacaoMapper.getObservacoesList(obs,observacaoDTOList) );

        return observacaoDTOList;
    }

    public Observacao findById(Long id) {
        return this.observacaoRepository.getOne(id);
    }

    public void save(ObservacaoDTO observacaoDTO) {
        var observacao = this.observacaoMapper.getObservacao(observacaoDTO);
        this.observacaoRepository.save(observacao);
    }

    public ObservacaoDTO update(ObservacaoDTO observacaoDTO) {
        var observacaoToBeUpdated = this.observacaoMapper.getObservacao(observacaoDTO);
        var observacao = this.findById(observacaoDTO.getId());

        if(this.mayUpdateObservacao(observacaoToBeUpdated,observacao)) {
           observacaoDTO = this.observacaoMapper.getObservacaoDTO(this.observacaoRepository.save(observacaoToBeUpdated));
        }
        return observacaoDTO;
    }
    public boolean mayUpdateObservacao(Observacao observacaoToBeUpdated, Observacao observacao) {
        return observacaoToBeUpdated.getObservacoesOficina() != observacao.getObservacoesOficina() ||
                observacaoToBeUpdated.getRevisao() != observacao.getRevisao() ||
                observacaoToBeUpdated.getMecanica() != observacao.getMecanica() ||
                observacaoToBeUpdated.getPolimento() != observacao.getPolimento() ||
                observacaoToBeUpdated.getPintura() != observacao.getPintura()  ||
                observacaoToBeUpdated.getFunilaria() != observacao.getFunilaria() ||
                observacaoToBeUpdated.getHigienizacao() != observacao.getHigienizacao() ||
                observacaoToBeUpdated.getTransferencia() != observacao.getTransferencia();
    }

    public void delete(Long id) {
        var observacaoToBeDeleted = this.observacaoRepository.findById(id).orElseThrow(IllegalStateException::new);
        this.observacaoRepository.delete(observacaoToBeDeleted);
    }

}
