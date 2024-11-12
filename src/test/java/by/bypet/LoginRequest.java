package by.bypet;

public class LoginRequest {
    public static final String URL_LOGIN = "https://bypet.by/auth/login";

    public static String getBody() {
        return "{\"phone_stripped\":\"+375291384195\",\n" +
                "\"phone\":\"+375 (29) 138-41-95\",\n" +
                "\"password\":\"123dsfafsd\"}";
    }
}
