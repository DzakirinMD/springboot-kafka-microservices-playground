package net.dzakirinmd.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class going to be used for transfer data between Producer and Consumer using apache kafka
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDto {

    private String message;
    private String status;
    private OrderDto orderDto;

}
