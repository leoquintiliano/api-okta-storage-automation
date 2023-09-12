package br.com.leadersofts.apioktastorage.marca.resource;

import br.com.leadersofts.apioktastorage.marca.dto.MarcaDTO;
import br.com.leadersofts.apioktastorage.marca.service.MarcaService;
import br.com.leadersofts.apioktastorage.modelo.service.ModeloService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
//@CrossOrigin
public class MarcaResource {

    @Autowired
    private MarcaService service;

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/list")
    public ResponseEntity<List<MarcaDTO>> findAll() {

        var marcasFetched = this.service.findAll();

        if(marcasFetched.isEmpty()) {
            var marcas = this.service.fetchAllBrands("general");
            return new ResponseEntity(this.service.getMarcasDTOFromPojo(marcas, "general"), HttpStatus.OK);
        }

        return new ResponseEntity(this.service.getMarcasDTO(marcasFetched),HttpStatus.OK);

    }

    @GetMapping("/list/{tipoVeiculo}")
    public ResponseEntity<List<MarcaDTO>> findAllByVehicleType(@PathVariable("tipoVeiculo") String tipoVeiculo) {

        var marcasFetched = this.service.findAllAccordingToItsKind(tipoVeiculo);

        if(marcasFetched.isEmpty()) {
            var marcas = this.service.fetchAllBrands(tipoVeiculo);
            return new ResponseEntity(this.service.getMarcasDTOFromPojo(marcas,tipoVeiculo), HttpStatus.OK);
        }

        return new ResponseEntity(this.service.getMarcasDTO(marcasFetched),HttpStatus.OK);

    }


    @GetMapping("/find/{id}")
    public ResponseEntity<MarcaDTO> findById(@PathVariable("id") Long id) {
        var marcaDTO = this.service.findById(id);
        return new ResponseEntity(marcaDTO, HttpStatus.OK);
    }

    @GetMapping("/fetchAllFromFipe")
    @ResponseStatus(HttpStatus.OK)
    public void fetchAllBrandsFromFipe() {

        var marcasFetched = this.service.findAll();

        if(marcasFetched.isEmpty()) {
            var marcas =  this.service.fetchAllBrands("general");
            marcasFetched = this.service.fetchBrandsFromFipeToModelObject(marcas);
        }

        var modelosFetched = this.modeloService.findAll();

        if(modelosFetched.isEmpty()) {
            this.modeloService.fetchAllVehicles(marcasFetched);
        }

    }

}
