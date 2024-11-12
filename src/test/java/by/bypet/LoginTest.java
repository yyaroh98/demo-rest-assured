package by.bypet;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {
    @Test
    @Description("Code 200")
    public void test1() {
        given().
                body(by.bypet.LoginRequest.getBody()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().
                all().
                statusCode(422);
    }
}