package br.com.leadersofts.apioktastorage.client.converters;

import br.com.leadersofts.apioktastorage.anoveiculo.pojo.AnoVeiculoPojo;
import br.com.leadersofts.apioktastorage.marca.pojo.Marca;
import br.com.leadersofts.apioktastorage.modelo.pojo.Modelo;
import br.com.leadersofts.apioktastorage.veiculo.pojo.Veiculo;

import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class FipeConverter {

    public List<AnoVeiculoPojo> getAnosVeiculosObject(LinkedHashMap entity) {

        var anoVeiculoList = (List) entity.get("key");

        List<AnoVeiculoPojo> anoVeiculos = new ArrayList();

        StreamSupport.stream(anoVeiculoList.spliterator(), false)
                .map( accumulator -> {
                    var codigo = ((LinkedHashMap) accumulator).get("codigo").toString();
                    var nome = ((LinkedHashMap) accumulator).get("nome").toString();
                    var anoVeiculo = AnoVeiculoPojo.builder()
                            .codigo(codigo)
                            .nome(nome.toString())
                            .build();
                    anoVeiculos.add(anoVeiculo);
                    return accumulator;
                })
                .collect(Collectors.toList());

        return anoVeiculos;

    }

    public static List<Modelo> getModelos(ResponseEntity<LinkedHashMap> entity) {

        var modelosList = (List) entity.getBody().get("modelos");

        List<Modelo> modeloVeiculos = new ArrayList<>();

        modelosList.stream()
                .map( accumulator -> {
                    var codigo = ((LinkedHashMap) accumulator ).get("codigo").toString();
                    var nome = ((LinkedHashMap) accumulator ).get("nome");
                    var modelo = Modelo.builder()
                            .codigo(codigo)
                            .nome(nome.toString())
                            .build();
                    modeloVeiculos.add(modelo);
                    return accumulator;
                })
                .collect(Collectors.toList());

        return modeloVeiculos;
    }

    public static List<Marca> getMarcas(ResponseEntity<List> entity, List<Marca> marcasFipe) {

        Collection collection = entity.getBody();
        StreamSupport.stream(collection.spliterator(), false)
                .map(mapper -> {
                    var codigoString = String.valueOf(((LinkedHashMap) mapper).get("codigo"));
                    var codigo = Long.parseLong(codigoString);
                    var nome = String.valueOf(((LinkedHashMap) mapper).get("nome"));
                    var marcaFipe = Marca.builder()
                            .codigo(codigo)
                            .nome(nome)
                            .build();
                    return marcasFipe.add(marcaFipe);
                }).collect(Collectors.toList());

        return marcasFipe;
    }

    public static Veiculo getVeiculo(String valor, String tipoVeiculo, String anoModelo, String codigoFipe, String marca, String siglaCombustivel, String mesReferencia, String modelo, String combustivel) {
        var spplitedValue = Stream.of(valor.split(" "))
                .collect(Collectors.toList())
                .get(1)
                .replace("","")
                .replace(".","")
                .replace(",","");

        var veiculoFipe = Veiculo.builder()
                .tipoVeiculo( Long.parseLong(tipoVeiculo))
                .anoModelo(Long.parseLong(anoModelo))
                .codigoFipe(codigoFipe)
                .valor(Float.parseFloat(spplitedValue))
                .marca(marca)
                .siglaCombustivel(siglaCombustivel)
                .mesReferencia(mesReferencia)
                .modelo(modelo)
                .combustivel(combustivel)
                .build();
        return veiculoFipe;
    }


}
