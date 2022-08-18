package net.dzakirinmd.stockservice.model;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "stock_service")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderId;
    private String orderName;
    private int orderQty;
    private double orderPrice;
}
