package kzs.com.br.sales_system.service;

import kzs.com.br.sales_system.model.Client;
import kzs.com.br.sales_system.repository.ClientsRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
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
