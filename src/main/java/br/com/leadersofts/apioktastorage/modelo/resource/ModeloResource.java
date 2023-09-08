package br.com.leadersofts.apioktastorage.modelo.resource;
import br.com.leadersofts.apioktastorage.modelo.dto.ModeloDTO;
import br.com.leadersofts.apioktastorage.modelo.service.ModeloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/modelo")
@CrossOrigin
public class ModeloResource {

    @Autowired
    private ModeloService service;

    @GetMapping("/list")
    public ResponseEntity<List<ModeloDTO>> findAll() {
        var modelos = this.service.findAll();
        return new ResponseEntity(modelos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ModeloDTO> findById(@PathVariable("id") Long id) {

        var modeloDTO = this.service.findById(id);

        return new ResponseEntity(modeloDTO, HttpStatus.OK);
    }

    @GetMapping("/findAllByMarca/{id}/{name}/{tipoVeiculo}")
    public ResponseEntity<List<ModeloDTO>> findByName(@PathVariable("id") Long idMarca, @PathVariable("name") String name, @PathVariable("tipoVeiculo") String tipoVeiculo) {

        var modelosFetched = this.service.findModelosByName(idMarca,name);

        List<ModeloDTO> veiculosListDTO = new ArrayList();

        if(modelosFetched.isEmpty())
            veiculosListDTO = this.service.findModelosByMarca(idMarca,tipoVeiculo);
        else
            veiculosListDTO = modelosFetched;

        return new ResponseEntity(veiculosListDTO,HttpStatus.OK);
    }

}
