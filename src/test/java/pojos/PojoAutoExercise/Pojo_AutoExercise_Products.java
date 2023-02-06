package pojos.PojoAutoExercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pojo_AutoExercise_Products {

private int id;
private String name;
private String price;
private String brand;
private Pojo_AutoExercise_Category category;

}
