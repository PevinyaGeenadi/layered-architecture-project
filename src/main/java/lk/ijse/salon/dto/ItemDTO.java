package lk.ijse.salon.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ItemDTO {
    private String ItemCode;
    private String ItemProductName;
    private String ItemUnitPrice;
    private String ItemType;
    private String ItemmfgDate;
    private String ItemDate;
    private String ItemQOH;

}
