package br.com.leadersofts.apioktastorage.observacao.resource;

import br.com.leadersofts.apioktastorage.observacao.dto.ObservacaoDTO;
import br.com.leadersofts.apioktastorage.observacao.mapper.ObservacaoMapper;
import br.com.leadersofts.apioktastorage.observacao.service.ObservacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/observacao")
public class ObservacaoResource {

    @Autowired
    private ObservacaoService observacaoService;

    @Autowired
    private ObservacaoMapper mapper;

    @GetMapping("/list")
    public ResponseEntity<List<ObservacaoDTO>> findAll() {
        var observacoes = Optional.of(this.observacaoService.findAll())
                .orElseThrow( () -> new IllegalStateException("None [Observacao] was found!") );

        return ResponseEntity.ok(observacoes);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        var observacao = this.observacaoService.findById(id);
        return ResponseEntity.ok(mapper.getObservacaoDTO(observacao));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody ObservacaoDTO observacaoDTO) {
        this.observacaoService.save(observacaoDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ObservacaoDTO observacaoDTO) {
        this.observacaoService.update(observacaoDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        this.observacaoService.delete(id);
    }

}
