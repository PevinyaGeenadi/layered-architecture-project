package lk.ijse.salon.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetails {
    private String  productId;
    private String  orderId;
    private Integer qty;
}
