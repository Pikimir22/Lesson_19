import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class ApiTest {

    @BeforeAll
    static void baseUrl() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";

    }

    @Test
    @Description("Registration")
    void registrTest() {


        Map<String, String> test = new HashMap<>();

        test.put("Gender", "M");
        test.put("FirstName", "e");
        test.put("LastName", "ew");
        test.put("Email", "wqe@gmail.ru");
        test.put("password", "123456");
        test.put("ConfirmPassword", "123456");

        given()
                .log().all()
                .contentType("text/html; charset=utf-8")
                .formParams(test)
                .when()
                .post("/register")
                .then()
                .statusCode(302)
                .cookie("Nop.customer");


    }

}
