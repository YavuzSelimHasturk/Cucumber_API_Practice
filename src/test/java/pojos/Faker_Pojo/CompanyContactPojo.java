package pojos.Faker_Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyContactPojo {

    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String birthday;
    private String gender;
    private CompanyContactAdressPojo address;
    private String website;
    private String image;
}
