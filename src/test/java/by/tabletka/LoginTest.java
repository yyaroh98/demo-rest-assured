package by.tabletka;

import org.junit.jupiter.api.Test;
import jdk.jfr.Description;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    @Test
    @Description("Code 200")
    public void test1() {
        given().
                body(LoginRequest.getBody()).
                headers(LoginRequest.getHeaders()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().
                all().
                statusCode(200);
    }

    @Test
    @Description("Code 400")
    public void test2() {
        String body = "_csrf=i1GClPTEanPyiWMBGZ5YT8bqWZamJY3KCp3G2qwn-IzlOuX4xI4cMJbxUEQ0_wcoiKVuw89OuZJQrKTs_WHN5A%3D%3D&" +
                "email=123%40mail.ru&" +
                "password=12343245&" +
                "rememberMe=on";
        given().
                body(body).
                header("X-Requested-With", "XMLHttpRequest").
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().
                all().
                statusCode(400);
    }

    @Test
    @Description("log - null")
    public void test3() {
        String body = "_csrf=i1GClPTEanPyiWMBGZ5YT8bqWZamJY3KCp3G2qwn-IzlOuX4xI4cMJbxUEQ0_wcoiKVuw89OuZJQrKTs_WHN5A%3D%3D&" +
                "email=123%40mail.ru&" +
                "password=12343245&" +
                "rememberMe=on";
        given().
                body(body).
                header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                header("Cookie", "PHPSESSID=km8fmbmbblmp883diak5j7tput; _csrf=750a606f1a6b663e680ee79a0c64b361a937" +
                        "89572db4cfa9e9e3220d154a3902a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22nkgl0" +
                        "JvCdx3E-a_gNO7Uik4XZ1b6QF5h%22%3B%7D; _ga=GA1.1.393215753.1730995408; regionId=0; _ga_S6LL4MRH4" +
                        "6=GS1.1.1730997671.2.1.1730997687.0.0.0").
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().
                all().
                statusCode(200).
                body("log", equalTo(null));
    }
}
