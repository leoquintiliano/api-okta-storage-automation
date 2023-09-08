package br.com.leadersofts.apioktastorage.estoque.service;

import br.com.leadersofts.apioktastorage.estoque.domain.Estoque;
import br.com.leadersofts.apioktastorage.estoque.dto.EstoqueDTO;
import br.com.leadersofts.apioktastorage.estoque.mapper.EstoqueMapper;
import br.com.leadersofts.apioktastorage.estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueMapper estoqueMapper;

    public List<Estoque> findAll() {
        return this.estoqueRepository.findAll();
    }

    public Optional<Estoque> findById(Long id) {
        return Optional.of(this.estoqueRepository.getOne(id));
    }

    public void save(EstoqueDTO estoqueDTO) {
        var estoque = this.estoqueMapper.getEstoque(estoqueDTO);
        this.estoqueRepository.save(estoque);
    }

    public void delete(Long id) {
        var estoqueToBeDeleted = this.estoqueRepository.findById(id).orElseThrow( () -> new IllegalStateException("None [estoque] was found!") );
        if(estoqueToBeDeleted.getVeiculos().size() > 0){
            throw new RuntimeException("Não foi possível deletar o estoque, verifique se não há veículos associados ao estoque!");
        }
        this.estoqueRepository.delete(estoqueToBeDeleted);
    }

//    public Optional<Veiculo> consumirApiTabelaFipe(Long idMarca) {
//        return this.fipeClient.consumirApiTabelaFipe(idMarca,"");
//    }

}
