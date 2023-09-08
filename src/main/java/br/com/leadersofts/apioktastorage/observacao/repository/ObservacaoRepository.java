package br.com.leadersofts.apioktastorage.observacao.repository;

import br.com.leadersofts.apioktastorage.observacao.domain.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacaoRepository extends JpaRepository<Observacao,Long> {

}
