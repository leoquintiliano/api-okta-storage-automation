package br.com.leadersofts.apioktastorage.estoque.mapper;

import br.com.leadersofts.apioktastorage.veiculo.domain.Veiculo;
import br.com.leadersofts.apioktastorage.veiculo.mapper.VeiculoMapper;

import br.com.leadersofts.apioktastorage.estoque.domain.Estoque;
import br.com.leadersofts.apioktastorage.estoque.dto.EstoqueDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class EstoqueMapper {

    @Autowired
    VeiculoMapper veiculoMapper;

    public EstoqueDTO getEstoqueDTO(Estoque estoque) {

        if(Objects.nonNull(estoque)) {
            return EstoqueDTO.builder()
                    .veiculos(Arrays.asList(veiculoMapper.getVeiculoDTO(this.getVeiculos(estoque).get(0))))
                    .diasNoEstoque( !Objects.isNull(estoque.getId()) ? estoque.getId() : 0L)
                    .dataEntrada(!Objects.isNull(estoque.getDataEntrada()) ? estoque.getDataEntrada() : LocalDate.now())
                    .dono(!Objects.isNull(estoque.getDono()) ? estoque.getDono() : "")
                    .estoque(!Objects.isNull(estoque.getEstoque()) ? estoque.getEstoque() : "")
                    .marca(!Objects.isNull(estoque.getMarca()) ? estoque.getMarca() : "")
                    .media(!Objects.isNull(estoque.getMedia()) ? estoque.getMedia() : 0F)
                    .origem(!Objects.isNull(estoque.getOrigem()) ? estoque.getOrigem() : "")
                    .quantidade(!Objects.isNull(estoque.getQuantidade()) ? estoque.getQuantidade() : 0L)
                    .status(!Objects.isNull(estoque.getStatus()) ? estoque.getStatus() : "")
                    .build();
        }
        return new EstoqueDTO();
    }

    public Estoque getEstoque(EstoqueDTO estoqueDTO) {
        if(Objects.nonNull(estoqueDTO)) {
            return Estoque.builder()
                    .veiculos( Arrays.asList( veiculoMapper.getVeiculo(estoqueDTO.getVeiculos().get(0))) )
                    .diasNoEstoque( !Objects.isNull(estoqueDTO.getId()) ? estoqueDTO.getId() : 0L)
                    .dataEntrada(!Objects.isNull(estoqueDTO.getDataEntrada()) ? estoqueDTO.getDataEntrada() : LocalDate.now())
                    .dono(!Objects.isNull(estoqueDTO.getDono()) ? estoqueDTO.getDono() : "")
                    .estoque(!Objects.isNull(estoqueDTO.getEstoque()) ? estoqueDTO.getEstoque() : "")
                    .marca(!Objects.isNull(estoqueDTO.getMarca()) ? estoqueDTO.getMarca() : "")
                    .media(!Objects.isNull(estoqueDTO.getMedia()) ? estoqueDTO.getMedia() : 0F)
                    .origem(!Objects.isNull(estoqueDTO.getOrigem()) ? estoqueDTO.getOrigem() : "")
                    .quantidade(!Objects.isNull(estoqueDTO.getQuantidade()) ? estoqueDTO.getQuantidade() : 0L)
                    .status(!Objects.isNull(estoqueDTO.getStatus()) ? estoqueDTO.getStatus() : "")
                    .build();
        }
        return new Estoque();
    }

    public List<Veiculo> getVeiculos(Estoque estoque) {
        return Objects.nonNull(estoque.getVeiculos()) && !estoque.getVeiculos().isEmpty() ? estoque.getVeiculos() : new ArrayList<>();
    }


}
