package kzs.com.br.sales_system.domain.repository;

import kzs.com.br.sales_system.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
