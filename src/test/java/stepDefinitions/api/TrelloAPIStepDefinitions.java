package stepDefinitions.api;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class TrelloAPIStepDefinitions {
    RequestSpecification spec;
    Response response;

    @Before(order = 0)
    public void beforeAPIScenario() {
       spec= new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base_url_trello"))
                .build();
    }
    @Given("Trello URL icin gerekli path ve querry parametreleri hazirlanir")
    public void trello_url_icin_gerekli_path_ve_querry_parametreleri_hazirlanir() {
            spec.pathParams("pp1",1,"pp2","boards").queryParams("name","create a board","key",ConfigReader.getProperty("trelloKey"),"token",ConfigReader.getProperty("trelloToken"));
    }
    @Then("Trello Post sorgusu icin gerekli expected data hazirlanir")
    public void trello_post_sorgusu_icin_gerekli_expected_data_hazirlanir() {

    }
    @Then("Trello Post sorgusu sonucu donen response kaydedilir")
    public void trello_post_sorgusu_sonucu_donen_response_kaydedilir() {

        response=given().spec(spec).when().post("/{pp1}/{pp2");
        response.prettyPrint();
    }
    @Then("Trello Post sorgusu sonucu donen response assert edilir")
    public void trello_post_sorgusu_sonucu_donen_response_assert_edilir() {


    }
}
