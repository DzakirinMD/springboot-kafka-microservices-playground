package net.dzakirinmd.stockservice.repository;

import net.dzakirinmd.stockservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
