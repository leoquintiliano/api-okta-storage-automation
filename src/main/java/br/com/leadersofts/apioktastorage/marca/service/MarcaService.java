package br.com.leadersofts.apioktastorage.marca.service;

import br.com.leadersofts.apioktastorage.client.MotoFipeClient;
import br.com.leadersofts.apioktastorage.client.VeiculoFipeClient;
import br.com.leadersofts.apioktastorage.enums.TipoVeiculoEnum;
import br.com.leadersofts.apioktastorage.marca.dto.MarcaDTO;
import br.com.leadersofts.apioktastorage.marca.mapper.MarcaMapper;
import br.com.leadersofts.apioktastorage.marca.pojo.Marca;
import br.com.leadersofts.apioktastorage.marca.repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    @Autowired
    private MarcaMapper mapper;

    @Autowired
    private MotoFipeClient motoFipeClient;

    @Autowired
    private VeiculoFipeClient veiculoFipeClient;

    public MarcaDTO findById(Long id) {
        var marca = this.repository.findById(id).orElseThrow(() -> new IllegalStateException("None [marca] could be found!"));
        return mapper.getMarcaDTO(marca);
    }

    public List<MarcaDTO> getMarcasDTOFromPojo(List<Marca> marcasList, String tipoVeiculo) {

        List<MarcaDTO> marcas = new ArrayList<>();

        marcasList.forEach(marca -> {
            br.com.leadersofts.apioktastorage.marca.domain.Marca marcaDomain = br.com.leadersofts.apioktastorage.marca.domain.Marca.builder()
                    .id(marca.getId())
                    .codigo(marca.getCodigo())
                    .nome(marca.getNome())
                    .tipoVeiculo(tipoVeiculo)
                    .build();
            marcas.add(mapper.getMarcaDTO(marcaDomain));
        });

        return marcas;

    }

    public List<MarcaDTO> getMarcasDTO(List<br.com.leadersofts.apioktastorage.marca.domain.Marca> marcasList) {

        List<MarcaDTO> marcas = new ArrayList<>();

        marcasList.forEach(marca -> {
            br.com.leadersofts.apioktastorage.marca.domain.Marca marcaDomain = br.com.leadersofts.apioktastorage.marca.domain.Marca.builder()
                    .id(marca.getId())
                    .codigo(marca.getCodigo())
                    .nome(marca.getNome())
                    .build();
            marcas.add(mapper.getMarcaDTO(marcaDomain));
        });

        return marcas;
    }

    public List<Marca> fetchAllBrands(String tipoVeiculo) {

        if(tipoVeiculo.equals(TipoVeiculoEnum.MOTORCYCLE.getValue()) ) {
            this.motoFipeClient.initValues();
            return this.motoFipeClient.getMarcasVeiculos();
        } else if (tipoVeiculo.equals(TipoVeiculoEnum.AUTOMOBIL.getValue()) ) {
            this.veiculoFipeClient.initValues();
            return this.veiculoFipeClient.getMarcasVeiculos();
        }

        this.veiculoFipeClient.initValues();
        return this.veiculoFipeClient.getMarcasVeiculos();

    }

    public List<br.com.leadersofts.apioktastorage.marca.domain.Marca> fetchBrandsFromFipeToModelObject(List<Marca> marcas) {
        List<br.com.leadersofts.apioktastorage.marca.domain.Marca> marcasList = new ArrayList<>();
        for(Marca marca : marcas) {
            var marcaToPersist = this.mapper.getMarcaFromPOJO(marca);
            var marcaPersisted = this.repository.save(marcaToPersist);
            marcasList.add(marcaPersisted);
        }
        return marcasList;
    }

    public List<br.com.leadersofts.apioktastorage.marca.domain.Marca> findAll() {
        return this.repository.findAll();
    }

    public List<br.com.leadersofts.apioktastorage.marca.domain.Marca> findAllAccordingToItsKind(String tipoVeiculo) {
        return this.repository.findAllAccordingToItsKind(tipoVeiculo);
    }
}
