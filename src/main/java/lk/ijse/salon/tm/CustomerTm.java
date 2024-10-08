package lk.ijse.salon.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerTm {
    private String custID;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String lane;
    private String contact;
}
