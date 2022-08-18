package net.dzakirinmd.stockservice.repository;

import net.dzakirinmd.stockservice.model.StoredOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredOrderRepository extends JpaRepository<StoredOrder, Long> {
}
