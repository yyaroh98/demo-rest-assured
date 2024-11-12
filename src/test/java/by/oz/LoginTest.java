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
                .body("error", equalTo("Введите корректный номер мобильного телефона"));
    }

    @Test
    @DisplayName("Test login with empty phone")
    public void testLoginWithEmptyPhone() {
        String phone = "";

        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody(phone))
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("error", equalTo("Введите номер мобильного телефона белорусских операторов"));
    }

    @Test
    @DisplayName("Test login with incorrect login length")
    public void testLoginWithIncorrectPhoneLength() {
        String phone = "37529756";

        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody(phone))
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("error", equalTo("Введите номер мобильного телефона белорусских операторов"));
    }

    @Test
    @DisplayName("Test login with incorrect login with symbol")
    public void testLoginWithIncorrectPhoneWithSymbol() {
        String phone = "37529756#*02";

        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody(phone))
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("error", equalTo("Введите номер мобильного телефона белорусских операторов"));
    }

    @Test
    @DisplayName("Test login with empty body")
    public void testLoginWithEmptyBody() {
        String body= "";

        given()
                .spec(LoginRequest.requestSpecification)
                .body(body)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(500)
                .body("error", equalTo("Произошла ошибка на сервисе авторизации."));
    }
}