package kzs.com.br.sales_system.domain.repository;

import kzs.com.br.sales_system.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select c from Client c where c.name like %" + ":name" + "%")
    List<Client> findByNameLike(@Param("name") String name);

    List<Client> findByNameOrId(String name, Long id);

    List<Client> findByNameOrIdOrderById(String name, Long id);

    List<Client> findByNameLikeOrId(String name, Long id);

    @Query(value = "delete from Client c where c.name = :name")
    @Modifying  //Annottation necessary when use a delete or update with annotation @Query
    void deleteByName(@Param("name") String name);

    Boolean existsByName(String name);

    @Query("select c from Client c left join fetch c.orders o where c.id = :idClient")
    Client findClientFetchOrders(@Param("idClient") Long idClient);


}

