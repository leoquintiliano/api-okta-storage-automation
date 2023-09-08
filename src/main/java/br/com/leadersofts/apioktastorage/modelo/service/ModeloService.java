package br.com.leadersofts.apioktastorage.modelo.service;

import br.com.leadersofts.apioktastorage.client.MotoFipeClient;
import br.com.leadersofts.apioktastorage.client.VeiculoFipeClient;
import br.com.leadersofts.apioktastorage.enums.TipoVeiculoEnum;
import br.com.leadersofts.apioktastorage.marca.domain.Marca;
import br.com.leadersofts.apioktastorage.modelo.domain.Modelo;
import br.com.leadersofts.apioktastorage.modelo.dto.ModeloDTO;
import br.com.leadersofts.apioktastorage.modelo.mapper.ModeloMapper;
import br.com.leadersofts.apioktastorage.modelo.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository repository;

    @Autowired
    private ModeloMapper mapper;

    @Autowired
    private MotoFipeClient motoFipeClient;

    @Autowired
    private VeiculoFipeClient veiculoFipeClient;

    public List<ModeloDTO> findAll() {

        List<ModeloDTO> modelos = new ArrayList<>();

        this.repository.findAll()
                .stream()
                .forEach( mod -> {
                    modelos.add(mapper.getModeloDTO(mod));
                });

        return modelos;

    }

    public List<br.com.leadersofts.apioktastorage.modelo.dto.ModeloDTO> findModelosByName(Long idMarca, String modelo) {
        List<ModeloDTO> modelos = new ArrayList<>();
        this.repository.findModelosByName(modelo,idMarca)
                .stream()
                .forEach(mod -> modelos.add(mapper.getModeloDTO(mod)));

        return modelos;
    }

    public ModeloDTO findById(Long id) {
        var modelo =  this.repository.findById(id).orElseThrow(() -> new IllegalStateException("None [modelo] could be found!"));
        return mapper.getModeloDTO(modelo);
    }

    public List<ModeloDTO> findModelosByMarca(Long idMarca, String tipoVeiculo) {

        List<ModeloDTO> modelosDTO = new ArrayList<>();

        if(tipoVeiculo.equals(TipoVeiculoEnum.MOTORCYCLE.getValue())) {
            this.motoFipeClient.initValues();
            var modelosResponse = this.motoFipeClient.getModelosVeiculos(idMarca);
            for(br.com.leadersofts.apioktastorage.modelo.pojo.Modelo modelo : modelosResponse) {
                var modeloDTO = this.mapper.getModeloDTO(Modelo.builder().codigo(Long.parseLong(modelo.getCodigo())).nome(modelo.getNome()).codigoMarca(idMarca).tipoVeiculo(tipoVeiculo).build());
                modelosDTO.add(modeloDTO);
            }
            return modelosDTO;
        }

        this.veiculoFipeClient.initValues();
        var modelosResponse = this.veiculoFipeClient.getModelosVeiculos(idMarca);
        for(br.com.leadersofts.apioktastorage.modelo.pojo.Modelo modelo : modelosResponse) {
            var modeloDTO = this.mapper.getModeloDTO(Modelo.builder().codigo(Long.parseLong(modelo.getCodigo())).nome(modelo.getNome()).codigoMarca(idMarca).tipoVeiculo(tipoVeiculo).build());
            modelosDTO.add(modeloDTO);
        }
        return modelosDTO;

    }

    public void fetchAllVehicles(List<Marca> marcas) {

        for(Marca marca: marcas) {

            var modelosPojo = this.veiculoFipeClient.getModelosVeiculos(marca.getCodigo());

            for(br.com.leadersofts.apioktastorage.modelo.pojo.Modelo element : modelosPojo) {
                var modelo  = Modelo.builder()
                        .codigo(Long.parseLong(element.getCodigo()))
                        .nome(element.getNome())
                        .codigoMarca(marca.getCodigo())
                        .build();

                this.repository.saveAndFlush(modelo);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException("An error occurred while trying to connect to Fipe API and persist collection of objects");
                }
            }

        }

    }



}
