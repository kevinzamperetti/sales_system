package kzs.com.br.sales_system.domain.repository;

import kzs.com.br.sales_system.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
