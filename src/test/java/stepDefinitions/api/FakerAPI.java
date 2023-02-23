package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.*;

import pojos.Faker_Pojo.*;
import utilities.ConfigReader;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;


public class FakerAPI {
    private RequestSpecification spec;
    Response response;
    BooksDataPojo expectedBooksDataBody;

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

    @And("Faker apiden donen response'da books status {string}, code {int} ve total {int} oldugunu ve {string},{string},{string},{string} alanlarinin geldigini assert et")
    public void fakerApidenDonenResponseDaBooksStatusCodeVeTotalOldugunuVeAlanlarininGeldiginiAssertEt(String status, int code, int total, String title, String author, String genre, String description) {

        BooksAPIPojo respPojo= response.as(BooksAPIPojo.class);

        assertEquals(status,respPojo.getStatus());
        assertEquals(code,respPojo.getCode());
        assertEquals(total,respPojo.getTotal());
        assertEquals(respPojo.getData().length, total);

         BooksDataPojo respBooksDataPojo =respPojo.getData()[0];
         assertFalse(respBooksDataPojo.getAuthor().isEmpty());
         assertFalse(respBooksDataPojo.getTitle().isEmpty());
         assertFalse(respBooksDataPojo.getGenre().isEmpty());
         assertFalse(respBooksDataPojo.getDescription().isEmpty());

        System.out.println(respBooksDataPojo);

    }

    @And("Faker apiden donen response'da books status {string}, code {int} ve total {int} oldugunu ve de {string},{string},{string},{string} alanlarinin geldigini assert et")
    public void fakerApidenDonenResponseDaBooksStatusCodeVeTotalOldugunuVeDeAlanlarininGeldiginiAssertEt(String status, int code, int total, String arg3, String arg4, String arg5, String arg6) {
        CompanyAPIPojo respPojo = response.as(CompanyAPIPojo.class);
        assertEquals(status,respPojo.getStatus());
        assertEquals(code,respPojo.getCode());
        assertEquals(total,respPojo.getTotal());

        CompanyDataPojo respCompDataPojo = respPojo.getData()[0];
        assertFalse(respCompDataPojo.getCountry().isEmpty());
        assertFalse(respCompDataPojo.getWebsite().isEmpty());

        CompanyAddressesPojo respCompAdressesPojo = respCompDataPojo.getAddresses()[0];
        assertFalse(respCompAdressesPojo.getZipcode().isEmpty());

        CompanyContactPojo respCompContactPojo = respCompDataPojo.getContact();
        assertFalse(respCompContactPojo.getAddress().getCounty_code().isEmpty());


    }
}
