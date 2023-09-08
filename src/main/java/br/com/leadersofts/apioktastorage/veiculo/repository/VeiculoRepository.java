package br.com.leadersofts.apioktastorage.veiculo.repository;

import br.com.leadersofts.apioktastorage.veiculo.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query(value = "SELECT v FROM Veiculo v WHERE v.codigoFipe = :codigoFipe")
    Optional<Veiculo> findVeiculoByCodigoFipe(@Param("codigoFipe") String codigoFipe);

    @Query(value = "SELECT v FROM Veiculo v WHERE v.codigoAno = :codigoAno")
    Veiculo findVeiculoByCodigoAnoVeiculo( @Param("codigoAno") String codigoAno);

}