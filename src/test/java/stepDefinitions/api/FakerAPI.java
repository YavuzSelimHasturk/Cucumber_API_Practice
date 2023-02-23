package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.*;

import pojos.Faker_Pojo.AddressAPIPojo;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class FakerAPI {
    private RequestSpecification spec;
    Response response;

    @Before(order = 0)
    public void beforeAPIScenario() {
        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_fakerapi"))
                .build();
    }

    @Given("Faker api URL icin gerekli path param {string} ve query param {string}hazirla")
    public void fakerApiURLIcinGerekliPathParamVeQueryParamHazirla(String pathparam, String queryparam) {
        spec.pathParam("pp1",pathparam).queryParam("_quantity",queryparam);
    }
    @Then("Faker apiden gelen cevabi response kaydet")
    public void fakerApidenGelenCevabiResponseKaydet() {
        response  = given().spec(spec).when().get("/{pp1}");
        response.prettyPrint();
    }

    @And("Faker apiden donen response'da status {string}, code {int} ve total {int} oldugunu assert et")
    public void fakerApidenDonenResponseDaStatusCodeVeTotalOldugunuAssertEt(String status, int code, int total) {
        AddressAPIPojo respPojo = response.as(AddressAPIPojo.class);

        assertEquals(status,respPojo.getStatus());
        assertEquals(code,respPojo.getCode());
        assertEquals(total,respPojo.getTotal());


    }
}
