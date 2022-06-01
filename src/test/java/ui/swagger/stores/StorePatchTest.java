package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.TestBase;
import ui.swagger.model.StorePojo;

import static io.restassured.RestAssured.given;

public class StorePatchTest extends TestBase {
    @Test
    public void modifySingleStoreInfo() {

        StorePojo storePojo = new StorePojo();
        storePojo.setLat(44.96956);
        storePojo.setLng(-93.4495679);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "8")
                .when()
                .patch("/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}


