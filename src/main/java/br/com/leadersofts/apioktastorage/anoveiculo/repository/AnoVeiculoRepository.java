package br.com.leadersofts.apioktastorage.anoveiculo.repository;

import br.com.leadersofts.apioktastorage.anoveiculo.domain.AnoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnoVeiculoRepository extends JpaRepository<AnoVeiculo,Long> {

}
