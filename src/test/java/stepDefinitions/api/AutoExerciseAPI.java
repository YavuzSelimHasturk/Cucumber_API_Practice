package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.netty.util.internal.logging.InternalLogger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.openqa.selenium.json.Json;
import pojos.PojoAutoExercise.Pojo_AutoExercise_Category;
import pojos.PojoAutoExercise.Pojo_AutoExercise_ExpectedBody;
import pojos.PojoAutoExercise.Pojo_AutoExercise_Usertype;
import utilities.ConfigReader;


import javax.swing.text.Document;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.HttpURLConnection;


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
        response = given().spec(spec).contentType(ContentType.HTML).when().get("/{pp1}");
        response.prettyPrint();

    }

    @Then("Automation Exercise Api Get request sonucunda donen Response u assert et")
    public void automation_exercise_api_get_request_sonucunda_donen_response_u_assert_et() {

        JsonPath jsonPath = response.jsonPath();
        //assertEquals(200,jsonPath.get("Response Code"));


        JSONObject respJson = response.as(JSONObject.class);
        assertEquals(200,respJson.get("Response Code"));




    }

    @Given("Automation Exercise Api Post request icin gerekli URL ve Body hazirla")
    public void automation_exercise_api_post_request_icin_gerekli_url_ve_body_hazirla() {
        spec.pathParam("pp1","productList");

    }
    @Then("Automation Exercise Api Post request icin Expected Data hazirla")
    public void automation_exercise_api_post_request_icin_expected_data_hazirla() {
   //     expectedBody = new Pojo_AutoExercise_ExpectedBody(405,"This request method is not supported.","");
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

    @Given("Automation Exercise Api Put To All Brands List request icin gerekli URL ve Body hazirla")
    public void automationExerciseApiPutToAllBrandsListRequestIcinGerekliURLVeBodyHazirla() {
        spec.pathParam("pp1","brandsList");
    }

    @Then("Automation Exercise Api Put request icin Expected Data hazirla")
    public void automationExerciseApiPutRequestIcinExpectedDataHazirla() {
   //     expectedBody= new Pojo_AutoExercise_ExpectedBody(405,"This request method is not supported.");
    }

    @And("Automation Exercise Api Put to All Brands List request sonucunda donen Response kaydet")
    public void automationExerciseApiPutToAllBrandsListRequestSonucundaDonenResponseKaydet() {
        response = given().spec(spec).contentType(ContentType.HTML).when().body(expectedBody.toString()).put("/{pp1}");
          response.prettyPrint();

    }

    @And("Automation Exercise Api Put to All Brands request sonucunda donen Response u assert et")
    public void automationExerciseApiPutToAllBrandsRequestSonucundaDonenResponseUAssertEt() {
        Pojo_AutoExercise_ExpectedBody respPojo = response.as(Pojo_AutoExercise_ExpectedBody.class);
        assertEquals(expectedBody.getMessage(),respPojo.getMessage());
        assertEquals(expectedBody.getResponseCode(),respPojo.getResponseCode());
    }
}
