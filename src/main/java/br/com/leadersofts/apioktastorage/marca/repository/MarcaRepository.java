package br.com.leadersofts.apioktastorage.marca.repository;

import br.com.leadersofts.apioktastorage.marca.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {

    @Query("SELECT m FROM Marca m WHERE m.tipoVeiculo = :tipoVeiculo")
    List<Marca> findAllAccordingToItsKind(@Param("tipoVeiculo") String tipoVeiculo);
}
