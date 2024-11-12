package by.vek21;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {

    public static final String URL_LOGIN = "https://www.21vek.by/users/action/login/";

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-requested-with", "XMLHttpRequest");
        return headers;
    }

    public static String getBody(String email, String password) {
        return "{\"User\":{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}}";
    }
}
