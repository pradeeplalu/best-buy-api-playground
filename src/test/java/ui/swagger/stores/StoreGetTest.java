package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class StoreGetTest extends TestBase {
    @Test
    public void getAllStoresInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.then().time(lessThan(2000L));
        response.prettyPrint();
    }

    @Test
    public void getSingleStoreInfo() {
        Response response = given()
                .pathParam("id",8)
                .when()
                .get("/stores/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(2000L));
        response.prettyPrint();
    }
}



