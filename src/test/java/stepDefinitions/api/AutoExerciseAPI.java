package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import pojos.PojoAutoExercise.Pojo_AutoExercise_Category;
import pojos.PojoAutoExercise.Pojo_AutoExercise_ExpectedBody;
import pojos.PojoAutoExercise.Pojo_AutoExercise_Usertype;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class AutoExerciseAPI {

    Pojo_AutoExercise_ExpectedBody expectedBody;
    Pojo_AutoExercise_Category category;
    Pojo_AutoExercise_Usertype usertype;
    private RequestSpecification spec;
    Response response;

    @Before(order = 0)
    public void beforeAPIScenario() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_autoExercise"))
                .build();
    }

    @Given("Automation Exercise Api Get request icin gerekli URL ve Body hazirla")
    public void automation_exercise_api_get_request_icin_gerekli_url_ve_body_hazirla() {
       spec.pathParam("pp1","productList");

    }
    @Then("Automation Exercise Api Get request icin Expected Data hazirla")
    public void automation_exercise_api_get_request_icin_expected_data_hazirla() {


    }
    @Then("Automation Exercise Api Get request sonucunda donen Response kaydet")
    public void automation_exercise_api_get_request_sonucunda_donen_response_kaydet() {
        response = given().spec(spec).when().get("/{pp1}");
        response.prettyPrint();

    }
    @Then("Automation Exercise Api Get request sonucunda donen Response u assert et")
    public void automation_exercise_api_get_request_sonucunda_donen_response_u_assert_et() {
        JsonPath respJsonPath = response.jsonPath();
        assertEquals(expectedBody.getResponseCode(),response.getStatusCode());
        respJsonPath.prettyPrint();

    }

    @Given("Automation Exercise Api Post request icin gerekli URL ve Body hazirla")
    public void automation_exercise_api_post_request_icin_gerekli_url_ve_body_hazirla() {
        spec.pathParam("pp1","productList");
    }
    @Then("Automation Exercise Api Post request icin Expected Data hazirla")
    public void automation_exercise_api_post_request_icin_expected_data_hazirla() {

    }
    @Then("Automation Exercise Api Post request sonucunda donen Response kaydet")
    public void automation_exercise_api_post_request_sonucunda_donen_response_kaydet() {

    }
    @Then("Automation Exercise Api Post request sonucunda donen Response u assert et")
    public void automation_exercise_api_post_request_sonucunda_donen_response_u_assert_et() {

    }
}
