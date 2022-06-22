package kzs.com.br.sales_system;

import com.sun.org.apache.xpath.internal.operations.Bool;
import kzs.com.br.sales_system.domain.entity.Client;
import kzs.com.br.sales_system.domain.entity.Order;
import kzs.com.br.sales_system.domain.repository.ClientRepository;
import kzs.com.br.sales_system.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SalesSystemApplication {

    @Value("${application.name}")
    private String applicationName;



    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository,
                                  @Autowired OrderRepository orderRepository) {
        return args -> {

            System.out.println("Save clients:");
            Client kevin = new Client("Kevin");
            clientRepository.save(kevin);

            Order o = new Order();
            o.setClient(kevin);
            o.setDateOrder(LocalDate.now());
            o.setTotalOrder(BigDecimal.valueOf(100));
            orderRepository.save(o);

            Client clientFetchOrders = clientRepository.findClientFetchOrders(kevin.getId());
            System.out.println(clientFetchOrders);
            System.out.println(clientFetchOrders.getOrders());

            orderRepository.findByClient(kevin).forEach(System.out::println);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesSystemApplication.class, args);
    }
}
