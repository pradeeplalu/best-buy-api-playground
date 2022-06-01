package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.TestBase;
import ui.swagger.model.StorePojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class StorePostTest extends TestBase {
    @Test
    public void createAStore() {

        HashMap<Object,Object> services = new HashMap<>();
        services.put("id's","9");
        services.put("names","Geek Squad Services");
        services.put("createdAt","2016-11-17T17:56:35.881Z");
        services.put("updatedAt","2016-11-17T17:56:35.881Z");

        StorePojo storePojo = new StorePojo();
        storePojo.setName("Linux");
        storePojo.setType("BigBox");
        storePojo.setAddress("13513 Ridgedale Dr");
        storePojo.setAddress2("");
        storePojo.setCity("Hopkins");
        storePojo.setState("MN");
        storePojo.setZip("55305");
        storePojo.setLat(44.969658);
        storePojo.setLng(-93.449539);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        storePojo.setServices(services);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .body(storePojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}


