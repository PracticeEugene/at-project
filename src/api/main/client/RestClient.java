package src.api.main.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient {

    public Response get(String uri, ContentType contentType) {
        return given()
                .contentType(contentType)
                .when().get(uri)
                .then().log().all()
                .extract().response();
    }
}
