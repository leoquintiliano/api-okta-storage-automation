package br.com.leadersofts.apioktastorage.veiculo.resource;

import br.com.leadersofts.apioktastorage.veiculo.dto.VeiculoDTO;
import br.com.leadersofts.apioktastorage.veiculo.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/list")
//    private ResponseEntity<List<VeiculoDTO>> listVeiculos(HttpServletResponse response) {
//        response.addHeader("Access-Control-Allow-Origin","*");
//        response.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS, HEAD, TRACE, CONNECT");
//        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
    private ResponseEntity<List<VeiculoDTO>> listVeiculos() {
        var veiculosResponse = this.veiculoService.findAll();
        var veiculos = this.veiculoService.getVeiculos(veiculosResponse);
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        var veiculoResponse = this.veiculoService.findById(id).orElseThrow( () -> new IllegalStateException("[veiculo] was not found!"));
        return new ResponseEntity<VeiculoDTO>(this.veiculoService.getVeiculoDTO(veiculoResponse), HttpStatus.OK);
    }

    @GetMapping("/findByMarcaAndYear/marca/{brandCode}/modelo/{modelCode}/year/{yearCode}/{tipoVeiculo}")
    public ResponseEntity<?> findByMarcaAndYear(@PathVariable("brandCode") Long codigoMarca, @PathVariable("modelCode") Long codigoModelo,
                                                @PathVariable("yearCode") String yearCode, @PathVariable("tipoVeiculo") String tipoVeiculo) {

        var locatedVehicleIfPersistedYet = this.veiculoService.getVeiculoByCodigoAnoVeiculo(yearCode);

        if(Objects.isNull(locatedVehicleIfPersistedYet)) {
            var veiculoFipe = this.veiculoService.getVeiculoFipe(codigoMarca,codigoModelo,yearCode,tipoVeiculo);
            if(Objects.isNull(veiculoFipe.getId())) {
                return new ResponseEntity(veiculoFipe,HttpStatus.OK);
            }
        }

        return new ResponseEntity(locatedVehicleIfPersistedYet,HttpStatus.OK);

    }
    
    @GetMapping("/find/{id}/{name}")
    public ResponseEntity<?> findByName(@PathVariable("id") Long idMarca, @PathVariable("name") String name) {
        var veiculoDTO = this.veiculoService.findVeiculoByName(idMarca,name);
        return new ResponseEntity<VeiculoDTO>(veiculoDTO,HttpStatus.OK);
    }

    @GetMapping("/findByFipeCode/{codigoFipe}")
    public ResponseEntity<?> findByFipeCode(@PathVariable("codigoFipe") String codigoFipe) {
        var veiculoDTO = this.veiculoService.findVeiculoByCodigoFipe(codigoFipe);
        return new ResponseEntity<VeiculoDTO>(veiculoDTO,HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO veiculoDTO) {
        var vehicle = this.veiculoService.getVeiculoEntity(veiculoDTO);
        return new ResponseEntity<>(this.veiculoService.getVeiculoDTO(this.veiculoService.saveOrUpdate(vehicle)),HttpStatus.CREATED);
    }

}
