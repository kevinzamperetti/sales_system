package kzs.com.br.sales_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class MyConfiguration {

    @Bean
    public CommandLineRunner execute() {
        return args -> {
            System.out.println("Run in Development");
        };
    }

}
