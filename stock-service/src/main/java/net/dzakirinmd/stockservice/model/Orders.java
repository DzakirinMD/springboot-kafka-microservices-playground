package net.dzakirinmd.stockservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OrdersDetails")
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderId;
    private String orderName;
    private String orderEmailRecipient;
    private int orderQty;
    private double orderPrice;

    private String message;
    private String status;
}
