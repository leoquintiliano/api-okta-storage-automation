package br.com.leadersofts.apioktastorage.anoveiculo.service;

import br.com.leadersofts.apioktastorage.anoveiculo.domain.AnoVeiculo;
import br.com.leadersofts.apioktastorage.anoveiculo.mapper.AnoVeiculoMapper;
import br.com.leadersofts.apioktastorage.anoveiculo.repository.AnoVeiculoRepository;
import br.com.leadersofts.apioktastorage.client.MotoFipeClient;
import br.com.leadersofts.apioktastorage.client.VeiculoFipeClient;
import br.com.leadersofts.apioktastorage.enums.TipoVeiculoEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnoVeiculoService {

    @Autowired
    private AnoVeiculoRepository repository;

    @Autowired
    private AnoVeiculoMapper mapper;

    @Autowired
    private MotoFipeClient motoFipeClient;

    @Autowired
    private VeiculoFipeClient veiculoFipeClient;

    public List<AnoVeiculo> findAll() {
        return repository.findAll();
    }

    public List<AnoVeiculo> findAnoVeiculoByMarca(Long codigoMarca, Long codigoModelo, String tipoVeiculo) {

        if(tipoVeiculo.equals(TipoVeiculoEnum.MOTORCYCLE.getValue())) {
            this.motoFipeClient.initValues();
            var responseList = this.motoFipeClient.getAnosVeiculos(codigoMarca,codigoModelo);

            List<AnoVeiculo> anoVeiculoList = new ArrayList<>();

            responseList.forEach( elem -> {
                anoVeiculoList.add( this.mapper.getAnoVeiculoFromPojo(elem));
            });

            return anoVeiculoList;
        }

        var responseList = this.veiculoFipeClient.getAnosVeiculos(codigoMarca,codigoModelo);

        List<AnoVeiculo> anoVeiculoList = new ArrayList<>();

        responseList.forEach( elem -> {
            anoVeiculoList.add( this.mapper.getAnoVeiculoFromPojo(elem));
        });

        return anoVeiculoList;

    }

}
