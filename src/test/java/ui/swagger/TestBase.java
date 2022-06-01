package ui.swagger;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import ui.swagger.utils.TestUtils;

/**
 * Created by Jay Vaghani
 */
public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

    }
}
