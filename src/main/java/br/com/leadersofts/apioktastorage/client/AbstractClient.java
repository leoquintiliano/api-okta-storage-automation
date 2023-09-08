package br.com.leadersofts.apioktastorage.client;

import br.com.leadersofts.apioktastorage.veiculo.pojo.Veiculo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class AbstractClient {

    @Value("${fipe.api.url}")
    private String fipeAPIURL; // "http://api.fipeapi.com.br/v1/carros/22?{apikey}";

    @Value("${fipe.api.scheme}")
    String scheme;

    @Value("${fipe.api.host}")
    String host;

    String path = "";

    RestTemplate restTemplate = new RestTemplate();

    public void setPath(String path) {
        this.path = path;
    }

    public Optional<Veiculo> consumirApiTabelaFipe(Long idMarca, String nomeVeiculo) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host).
                path(path.concat(idMarca+"").concat("/").concat("/modelos").concat("/").concat(nomeVeiculo))
                .build();
        ResponseEntity<Veiculo> entity = this.restTemplate.getForEntity(uri.toUriString(), Veiculo.class);
        return Optional.of(new Veiculo());
    }

    static void sleep(int contadorConsultas) {

        if(contadorConsultas > 3) {
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                throw new RuntimeException("An error occurred while trying to connect to Fipe API and get collection of objects");
            }
        }

    }

}
