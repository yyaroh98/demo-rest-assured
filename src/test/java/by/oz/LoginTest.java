package by.oz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    @BeforeAll
    static void beforeAll() {
        LoginRequest.initRequestSpecification();
    }

    @Test
    @DisplayName("Test login with incorrect code phone")
    public void testLoginWithIncorrectCodePhone() {
        String phone = "375007560602";

        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody(phone))
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("message", equalTo("Введите корректный номер мобильного телефона"));
    }

    @Test
    @DisplayName("Test")
    public void testLoginWithEmptyPhone(){
        String phone = "";

        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody(phone))
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("message", equalTo("Введите номер мобильного телефона белорусских операторов"));
    }
}