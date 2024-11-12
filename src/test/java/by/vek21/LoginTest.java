package by.vek21;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @Test
    @DisplayName("test login with incorrect email")
    public void testLoginWithIncorrectEmail() {
        String email = "test@gmail.com";
        String password = "77323232";

        given()
                .body(LoginRequest.getBody(email, password))
                .headers(LoginRequest.getHeaders())
                .when()
                .post(LoginRequest.URL_LOGIN)
                .then()
                .log().all()
                .statusCode(200)
                .body("error", equalTo("Неправильный пароль"));
    }

    @Test
    @DisplayName("test login with incorrect password")
    public void testLoginWithIncorrectPassword() {
        String email = "test@gmail.com";
        String password = "77884223523";

        given()
                .body(LoginRequest.getBody(email, password))
                .headers(LoginRequest.getHeaders())
                .when()
                .post(LoginRequest.URL_LOGIN)
                .then()
                .log().all()
                .statusCode(200)
                .body("error", equalTo("Неправильный пароль"));
    }

    @Test
    @DisplayName("test login with incorrect email and password")
    public void testLoginWithIncorrectEmailAndPassword() {
        String email = "";
        String password = "";

        given()
                .body(LoginRequest.getBody(email, password))
                .headers(LoginRequest.getHeaders())
                .when()
                .post(LoginRequest.URL_LOGIN)
                .then()
                .log().all()
                .statusCode(200)
                .body("error", equalTo("Введите email"));

    }

    @Test
    @DisplayName("test login with incorrect password length")
    public void testLoginWithIncorrectPasswordLenght() {
        String email = "test@gmail.com";
        String password = "23";

        given()
                .body(LoginRequest.getBody(email, password))
                .headers(LoginRequest.getHeaders())
                .when()
                .post(LoginRequest.URL_LOGIN)
                .then()
                .log().all()
                .statusCode(200)
                .body("error", equalTo("Длина поля password должна быть от 6 до 32 символов"));

    }

    @Test
    @DisplayName("test login with incorrect format email")
    public void testLoginWithIncorrectFormatEmail() {
        String email = "test.com";
        String password = "23";

        given()
                .body(LoginRequest.getBody(email, password))
                .headers(LoginRequest.getHeaders())
                .when()
                .post(LoginRequest.URL_LOGIN)
                .then()
                .log().all()
                .statusCode(200)
                .body("error", equalTo("Ошибка валидации поля email"));

    }
}