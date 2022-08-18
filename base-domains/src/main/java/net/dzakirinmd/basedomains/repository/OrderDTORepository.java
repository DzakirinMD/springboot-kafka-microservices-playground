package net.dzakirinmd.basedomains.repository;

import net.dzakirinmd.basedomains.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDTORepository extends JpaRepository<OrderDTO,Long> {
}
