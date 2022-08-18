package net.dzakirinmd.stockservice.repository;

import net.dzakirinmd.stockservice.model.StockService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockServiceRepository extends JpaRepository<StockService, Long> {
}
