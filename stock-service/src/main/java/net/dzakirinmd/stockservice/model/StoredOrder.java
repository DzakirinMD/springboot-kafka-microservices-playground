package net.dzakirinmd.stockservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stored_order")
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoredOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderId;
    private String orderName;
    private int orderQty;
    private double orderPrice;

    private String message;
    private String status;
}
