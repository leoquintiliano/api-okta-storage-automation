package br.com.leadersofts.apioktastorage.client;

import br.com.leadersofts.apioktastorage.anoveiculo.pojo.AnoVeiculoPojo;
import br.com.leadersofts.apioktastorage.client.converters.FipeConverter;
import br.com.leadersofts.apioktastorage.marca.pojo.Marca;
import br.com.leadersofts.apioktastorage.modelo.pojo.Modelo;
import br.com.leadersofts.apioktastorage.veiculo.pojo.Veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public abstract class FipeClient extends AbstractClient {

    @Autowired
    private FipeConverter converter;

    public List<Marca> getMarcasVeiculos() {

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(path)
                .build();

        ResponseEntity<List> entity = this.restTemplate.getForEntity(uri.toUriString(), List.class);

        return this.converter.getMarcas(entity,new ArrayList<>());

    }

    public List<Modelo> getModelosVeiculos(Long codigoMarca) {

        super.sleep(1000);

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host).
                path(path.concat(codigoMarca+"").concat("/").concat("/modelos"))
                .build();
        ResponseEntity<LinkedHashMap> entity = this.restTemplate.getForEntity(uri.toUriString(), LinkedHashMap.class);

        return this.converter.getModelos(entity);

    }

    public List<AnoVeiculoPojo> getAnosVeiculos(Long codigoMarca, Long codigoModelo) {

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host).
                path(path.concat(codigoMarca+"").concat("/").concat("/modelos")
                        .concat("/").concat(codigoModelo+"").concat("/anos"))
                .build();
        ResponseEntity<Collection> entity = this.restTemplate.getForEntity(uri.toUriString(), Collection.class);

        LinkedHashMap result = new LinkedHashMap();
        result.put("key",entity.getBody());

        return this.converter.getAnosVeiculosObject(result);

    }

    public Veiculo getVeiculoTabelaFipe(Long codigoMarca, Long codigoModelo, String yearCode) {

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host).
                path(path.concat(codigoMarca+"").concat("/").concat("/modelos")
                        .concat("/").concat(codigoModelo+"").concat("/anos")
                        .concat("/").concat(yearCode))
                .build();

        var response = this.restTemplate.getForEntity(uri.toUriString(),LinkedHashMap.class).getBody();

        var tipoVeiculo = response.get("TipoVeiculo").toString();
        var valor = response.get("Valor").toString();
        var marca = response.get("Marca").toString();
        var modelo = response.get("Modelo").toString();
        var anoModelo = response.get("AnoModelo").toString();
        var combustivel = response.get("Combustivel").toString();
        var codigoFipe = response.get("CodigoFipe").toString();
        var mesReferencia = response.get("MesReferencia").toString();
        var siglaCombustivel = response.get("SiglaCombustivel").toString();

        return this.converter.getVeiculo(valor, tipoVeiculo, anoModelo, codigoFipe, marca, siglaCombustivel, mesReferencia, modelo, combustivel);

    }

    private List<Veiculo> getVeiculosFipeObject(Object veiculoResponse) {
//        LinkedHashMap entity;
//        var anoVeiculoList = (List) entity.get("key");

        LinkedHashMap keyResponse = (LinkedHashMap) veiculoResponse;

        List<Veiculo> veiculosFipe = new ArrayList();

//        StreamSupport.stream(anoVeiculoList.spliterator(), false)
//        StreamSupport.stream(keyResponse.spliterator(), false)
//                .map( accumulator -> {
//                    var tipoVeiculo = ((LinkedHashMap) accumulator).get("TipoVeiculo").toString();
//                    var anoModelo = ((LinkedHashMap) accumulator).get("AnoModelo").toString();
//                    var codigoFipe = ((LinkedHashMap) accumulator).get("CodigoFipe").toString();
//                    var valor = ((LinkedHashMap) accumulator).get("Valor").toString();
//                    var combustivel = ((LinkedHashMap) accumulator).get("Combustivel").toString();
//                    var siglaCombustivel = ((LinkedHashMap) accumulator).get("SiglaCombustivel").toString();
//                    var mesReferencia = ((LinkedHashMap) accumulator).get("MesReferencia").toString();
//                    var modelo = ((LinkedHashMap) accumulator).get("Modelo").toString();
//                    var marca = ((LinkedHashMap) accumulator).get("Marca").toString();
//
//                    var anoVeiculo = Veiculo.builder()
//                            .TipoVeiculo( Long.parseLong(tipoVeiculo))
//                            .AnoModelo(Long.parseLong(anoModelo))
//                            .CodigoFipe(codigoFipe)
////                            .Valor(Float.parseFloat(valor))
//                            .Valor(valor)
//                            .Marca(marca)
//                            .SiglaCombustivel(siglaCombustivel)
//                            .MesReferencia(mesReferencia)
//                            .Modelo(modelo)
//                            .Combustivel(combustivel)
//                            .build();
//                    veiculosFipe.add(anoVeiculo);
//                    return accumulator;
//                })
//                .collect(Collectors.toList());
//
//        return veiculosFipe;
        return null;

    }

}
