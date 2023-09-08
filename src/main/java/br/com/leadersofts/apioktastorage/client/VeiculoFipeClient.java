package br.com.leadersofts.apioktastorage.client;

import br.com.leadersofts.apioktastorage.marca.pojo.Marca;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoFipeClient extends FipeClient {

    @Value("${fipe.api.path}")
    private String path;

    public List<Marca> getMarcas() {
        super.setPath(path);
        return super.getMarcasVeiculos();
    }

    public void initValues() {
        super.setPath(this.path);
    }
}
