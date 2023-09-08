package br.com.leadersofts.apioktastorage.anoveiculo.resource;

import br.com.leadersofts.apioktastorage.anoveiculo.dto.AnoVeiculoDTO;
import br.com.leadersofts.apioktastorage.anoveiculo.service.AnoVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ano-veiculo")
@CrossOrigin
public class AnoVeiculoResource {

    @Autowired
    private AnoVeiculoService anoVeiculoService;

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity(this.anoVeiculoService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/findByMarca/marca/{brandCode}/modelo/{modelCode}/tipo/{tipoVeiculo}")
    public ResponseEntity<AnoVeiculoDTO> findByMarca(@PathVariable("brandCode") Long codigoMarca, @PathVariable("modelCode") Long codigoModelo,
                                                     @PathVariable("tipoVeiculo") String tipoVeiculo) {
        return new ResponseEntity(this.anoVeiculoService.findAnoVeiculoByMarca(codigoMarca,codigoModelo,tipoVeiculo), HttpStatus.OK);
    }

}
