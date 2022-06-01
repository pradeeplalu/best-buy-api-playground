package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.TestBase;
import ui.swagger.model.CategoriesPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CategoryPatchTest extends TestBase {
    @Test
    public void modifySingleCategoryInfo() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Besties Buy For Business");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "abcat0010000")
                .when()
                .patch("/categories/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}


