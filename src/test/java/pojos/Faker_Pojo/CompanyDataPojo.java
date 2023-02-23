package pojos.Faker_Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDataPojo{
    private int id;
    private String name;
    private String email;
    private String vat;
    private String phone;
    private String country;
    private CompanyAddressesPojo[] addresses;
    private String website;
    private String image;
    private CompanyContactPojo contact;

}