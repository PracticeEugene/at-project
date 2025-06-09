package api.util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public final class Parser {

    public static String getJsonValueByKey(Response response, String key) {
        return new JsonPath(response.body().asInputStream()).getString(key);
    }
}
