package kzs.com.br.sales_system;

import kzs.com.br.sales_system.domain.entity.Client;
import kzs.com.br.sales_system.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SalesSystemApplication {

    @Value("${application.name}")
    private String applicationName;

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
        return args -> {
            Client client = new Client("Kevin");
            clientRepository.save(client);

            Client client2 = new Client("Verônica");
            clientRepository.save(client2);

            List<Client> AllClients = clientRepository.getClients();
            AllClients.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesSystemApplication.class, args);
    }
}
