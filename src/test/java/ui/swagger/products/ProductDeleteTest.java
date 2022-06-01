package ui.swagger.products;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ProductDeleteTest extends TestBase {
    @Test
    public void deleteSingleProductInfo() {
        Response response = given()
                .pathParam("id", "127687")
                .when()
                .delete("/products/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}


