package kzs.com.br.sales_system.domain.repository;

import kzs.com.br.sales_system.domain.entity.Client;
import kzs.com.br.sales_system.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Set<Order> findByClient(Client client);

}
