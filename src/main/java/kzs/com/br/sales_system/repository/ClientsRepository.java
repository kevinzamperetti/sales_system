package kzs.com.br.sales_system.repository;

import kzs.com.br.sales_system.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientsRepository {

    private final ClientsRepository clientsRepository;

    public ClientsRepository(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void save(Client client) {
        validate(client);
        clientsRepository.save(client);
    }

    public void validate(Client client) {
        //validate Client
    }
}
