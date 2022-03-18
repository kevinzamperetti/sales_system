package kzs.com.br.sales_system.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {

    private Long id;
    private Client client;
    private LocalDate dateOrder;
    private BigDecimal TotalOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public BigDecimal getTotalOrder() {
        return TotalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        TotalOrder = totalOrder;
    }
}
