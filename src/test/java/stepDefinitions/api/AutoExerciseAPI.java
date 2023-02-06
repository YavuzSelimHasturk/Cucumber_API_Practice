package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import pojos.PojoAutoExercise.Pojo_AutoExercise_Category;
import pojos.PojoAutoExercise.Pojo_AutoExercise_ExpectedBody;
import pojos.PojoAutoExercise.Pojo_AutoExercise_Usertype;
import utilities.ConfigReader;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.CoreMatchers.hasItem;
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


    }
    @Then("Automation Exercise Api Get request sonucunda donen Response u assert et")
    public void automation_exercise_api_get_request_sonucunda_donen_response_u_assert_et() {

        assertEquals(404,response.statusCode());
    }

    @Given("Automation Exercise Api Post request icin gerekli URL ve Body hazirla")
    public void automation_exercise_api_post_request_icin_gerekli_url_ve_body_hazirla() {
        spec.pathParam("pp1","productList");

    }
    @Then("Automation Exercise Api Post request icin Expected Data hazirla")
    public void automation_exercise_api_post_request_icin_expected_data_hazirla() {
        expectedBody = new Pojo_AutoExercise_ExpectedBody(405,"This request method is not supported.");
    }
    @Then("Automation Exercise Api Post request sonucunda donen Response kaydet")
    public void automation_exercise_api_post_request_sonucunda_donen_response_kaydet() {
        response = given().spec(spec).contentType(ContentType.JSON).when().body(expectedBody.toString()).post("/{pp1}");
        response.prettyPrint();
    }
    @Then("Automation Exercise Api Post request sonucunda donen Response u assert et")
    public void automation_exercise_api_post_request_sonucunda_donen_response_u_assert_et() {

        Pojo_AutoExercise_ExpectedBody respPojo = response.as(Pojo_AutoExercise_ExpectedBody.class);
        assertEquals(expectedBody.getResponseCode(),respPojo.getResponseCode());
    }

    @Given("Automation Exercise Api Get All Brands request icin gerekli URL ve Body hazirla")
    public void automationExerciseApiGetAllBrandsRequestIcinGerekliURLVeBodyHazirla() {
        spec.pathParam("pp1","brandsList");
    }

    @And("Automation Exercise Api Get All Brands request sonucunda donen Response kaydet")
    public void automationExerciseApiGetAllBrandsRequestSonucundaDonenResponseKaydet() {
        response = given().spec(spec).contentType(ContentType.JSON).when().body(toString()).get("/{pp1}");
        response.prettyPrint();  
    }


    @And("Automation Exercise Api Get All Brands request sonucunda donen Response u assert et")
    public void automationExerciseApiGetAllBrandsRequestSonucundaDonenResponseUAssertEt() {
        assertEquals(200, response.statusCode());
    }
}
