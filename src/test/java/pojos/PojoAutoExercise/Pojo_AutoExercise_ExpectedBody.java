package pojos.PojoAutoExercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pojo_AutoExercise_ExpectedBody {

    private int responseCode;
    private String message;
    private JSONArray products;


}
