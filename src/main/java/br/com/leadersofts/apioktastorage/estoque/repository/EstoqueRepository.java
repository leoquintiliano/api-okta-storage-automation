package br.com.leadersofts.apioktastorage.estoque.repository;

import br.com.leadersofts.apioktastorage.estoque.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {

}
