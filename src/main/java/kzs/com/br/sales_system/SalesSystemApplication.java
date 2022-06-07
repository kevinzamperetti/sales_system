package kzs.com.br.sales_system;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
import java.util.Scanner;

@SpringBootApplication
public class SalesSystemApplication {

    @Value("${application.name}")
    private String applicationName;

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
        return args -> {

            System.out.println("Save clients:");
            clientRepository.save(new Client("Kevin"));
            clientRepository.save(new Client("Verônica"));

            List<Client> allClients = clientRepository.getClients();
            allClients.forEach(System.out::println);

            System.out.println("Update clients:");
            allClients.forEach(c -> {
                c.setName(c.getName() + " updated");
                clientRepository.update(c);
            });

            allClients = clientRepository.getClients();
            allClients.forEach(System.out::println);

            System.out.println("Find clients by name:");
            clientRepository.getClientByName("nica").forEach(System.out::println);

            System.out.println("Delete clients:");
            clientRepository.deleteById(2L);

            allClients = clientRepository.getClients();
            if (allClients.isEmpty()) {
                System.out.println("Clients is empty");
            } else {
                allClients.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesSystemApplication.class, args);
    }
}
