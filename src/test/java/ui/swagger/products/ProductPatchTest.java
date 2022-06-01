package ui.swagger.products;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.TestBase;
import ui.swagger.model.ProductPojo;

import static io.restassured.RestAssured.given;

public class ProductPatchTest extends TestBase {
    @Test
    public void modifySingleProductInfo() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setModel("MRI56923924");
        productPojo.setType("softwood");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "43900")
                .when()
                .patch("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

