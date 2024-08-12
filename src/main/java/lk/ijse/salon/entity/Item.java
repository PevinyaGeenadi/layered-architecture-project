package lk.ijse.salon.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Item {
    private String ItemCode;
    private String ItemProductName;
    private String ItemUnitPrice;
    private String ItemType;
    private String ItemmfgDate;
    private String ItemDate;
    private String ItemQOH;
}
