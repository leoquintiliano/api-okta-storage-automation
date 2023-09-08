package br.com.leadersofts.apioktastorage.modelo.repository;

import br.com.leadersofts.apioktastorage.modelo.domain.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo,Long> {


    @Query(value = "SELECT m FROM Modelo m WHERE m.nome = :modelo OR m.codigoMarca = :codigoMarca")
    public List<Modelo> findModelosByName(@Param("modelo") String modelo, @Param("codigoMarca") Long codigoMarca);

}
