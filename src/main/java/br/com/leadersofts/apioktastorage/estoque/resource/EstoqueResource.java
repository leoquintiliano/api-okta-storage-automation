package br.com.leadersofts.apioktastorage.estoque.resource;

import br.com.leadersofts.apioktastorage.client.FipeClient;
import br.com.leadersofts.apioktastorage.enums.StatusOficina;
import br.com.leadersofts.apioktastorage.enums.OrigemEnum;
import br.com.leadersofts.apioktastorage.enums.DonoEnum;
import br.com.leadersofts.apioktastorage.enums.StatusEnum;
import br.com.leadersofts.apioktastorage.enums.EstoqueEnum;

import br.com.leadersofts.apioktastorage.estoque.domain.Estoque;
import br.com.leadersofts.apioktastorage.estoque.dto.EstoqueDTO;
import br.com.leadersofts.apioktastorage.estoque.service.EstoqueService;
import br.com.leadersofts.apioktastorage.observacao.domain.Observacao;
import br.com.leadersofts.apioktastorage.veiculo.domain.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RestController
@RequestMapping("/estoque")
@CrossOrigin
public class EstoqueResource {

    @Autowired
    private EstoqueService estoqueService;

    private FipeClient fipeClient;

    @GetMapping(value = "/list")
    public ResponseEntity<List<EstoqueDTO>> listEstoque() {

//        var marcasVeiculos = this.estoqueService.getMarcasVeiculos();
//
//        var veiculoResponse = this.estoqueService.consumirApiTabelaFipe();
//
//        if(!veiculoResponse.isPresent()) {
//            throw new RuntimeException("None [veiculo] could be found. Please try again!");
//        }
//
//        var veiculoFipe = veiculoResponse.get();

        var veiculo = this.getVeiculoDummy();
        var estoque = new Estoque();

        this.setEstoqueDummy(veiculo, estoque);

        return new ResponseEntity(Stream.of(estoque),HttpStatus.OK);

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody EstoqueDTO estoqueDTO) {
        this.estoqueService.save(estoqueDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody EstoqueDTO estoqueDTO) {
        var storage = this.estoqueService.findById(id);
        this.estoqueService.save(estoqueDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.estoqueService.delete(id);
    }

    private void setEstoqueDummy(Veiculo veiculo, Estoque estoque) {
        estoque.setQuantidade(3L);
        estoque.setDataEntrada(LocalDate.now());
        estoque.setDiasNoEstoque(136L);
        estoque.setMedia(0.98F);
        estoque.setOrigem(OrigemEnum.BR.getValue());
        estoque.setDono(DonoEnum.ANDRE.getValue());
        estoque.setEstoque(EstoqueEnum.SAO_LOURENCO.getValue());
        estoque.setMarca(veiculo.getMarca());
        estoque.setStatus(StatusEnum.FREE.getValue());
        if(Objects.isNull(estoque.getVeiculos()))
            estoque.setVeiculos(new ArrayList<>());
        estoque.getVeiculos().add(veiculo);
        estoque.setObservacao(this.getObservacoesDummyData());
    }

    private Observacao getObservacoesDummyData() {
        return Observacao.builder()
                .observacoesOficina("Exemplo de texto, informações adicionais, teste, teste, teste de cliente, teste, teste")
                .id(1L)
                .funilaria(StatusOficina.FINALIZADO.getValue())
                .higienizacao(StatusOficina.FINALIZADO.getValue())
                .mecanica(StatusOficina.EM_PROCESSO.getValue())
                .revisao(StatusOficina.AGUARDANDO.getValue())
                .pintura(StatusOficina.AGUARDANDO.getValue())
                .polimento(StatusOficina.AGUARDANDO.getValue())
                .transferencia(StatusOficina.FINALIZADO.getValue())
                .build();
    }

    private Veiculo getVeiculoDummy() {
        var veiculo = new Veiculo();
        veiculo.setId(1L);
        veiculo.setNome("Cruze");
        veiculo.setMarca("Chevrolet");
        veiculo.setAnoModelo("2022/2023");
        veiculo.setCor("Branco");
        veiculo.setKilometragem(25_000);
        veiculo.setPlaca("LOL2027");
        return veiculo;
    }

}
