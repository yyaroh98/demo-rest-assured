package by.tabletka;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static final String URL_LOGIN = "https://tabletka.by/ajax-request/login";

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Cookie", "PHPSESSID=km8fmbmbblmp883diak5j7tput; _csrf=750a606f1a6b663e680ee79a0c64b361a93789572db4cfa9e9e3220d154a3902a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22nkgl0JvCdx3E-a_gNO7Uik4XZ1b6QF5h%22%3B%7D; _ga=GA1.1.393215753.1730995408; regionId=0; _ga_S6LL4MRH46=GS1.1.1730997671.2.1.1730997687.0.0.0");
        headers.put("X-Requested-With", "XMLHttpRequest");
        return headers;
    }

    public static String getBody() {
        return "_csrf=i1GClPTEanPyiWMBGZ5YT8bqWZamJY3KCp3G2qwn-IzlOuX4xI4cMJbxUEQ0_wcoiKVuw89OuZJQrKTs_WHN5A%3D%3D&email=123%40mail.ru&password=12343245&rememberMe=on";
    }
}
