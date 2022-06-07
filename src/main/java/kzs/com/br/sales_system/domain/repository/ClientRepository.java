package kzs.com.br.sales_system.domain.repository;

import kzs.com.br.sales_system.domain.entity.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClientRepository {

    private final EntityManager entityManager;

    public ClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Client save(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Transactional
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    @Transactional
    public void delete(Client client) {
        entityManager.remove(client);
    }

    @Transactional
    public void deleteById(Long id) {
        Client client = entityManager.find(Client.class, id);
        delete(client);
    }

    @Transactional(readOnly = true)
    public List<Client> getClients() {
        return entityManager.createQuery("from Client", Client.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Client> getClientByName(String name) {
        String jpql = "select c from Client c where c.name like :name";
        TypedQuery<Client> query = entityManager.createQuery(jpql, Client.class);
        query.setParameter("name", "%" + name +"%");
        return query.getResultList();
    }
}

