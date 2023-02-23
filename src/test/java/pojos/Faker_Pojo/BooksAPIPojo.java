package pojos.Faker_Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksAPIPojo {

    private String status;
    private int code;
    private int total;
    private BooksDataPojo[] data;

}
