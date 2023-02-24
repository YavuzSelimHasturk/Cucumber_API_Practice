package pojos.Faker_Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardsPojo {

    private String status;
    private int code;
    private int total;
    private CreditCardsDataPojo[] data;

}