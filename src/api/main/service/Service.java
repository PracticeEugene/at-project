package src.api.main.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import src.api.main.client.RestClient;

import static src.api.main.util.constant.EndpointConstants.*;
import static src.api.main.util.StringManager.getPathParam;
import static src.api.main.util.StringManager.joinEndpoints;

public class Service extends RestClient {
    public static final String API_BASE_URI = "https://wizard-world-api.herokuapp.com";

    public Response getAllWizards() {
        String uri = joinEndpoints(API_BASE_URI, WIZARDS_ENDPOINT);
        return get(uri, ContentType.JSON);
    }

    public Response getSpellByQueryParameter(String queryParameter) {
        String uri = joinEndpoints(API_BASE_URI, SPELLS_ENDPOINT, queryParameter);
        return get(uri, ContentType.JSON);
    }

    public Response getWizardById(String id) {
        String uri = joinEndpoints(API_BASE_URI, WIZARDS_ENDPOINT, getPathParam(id));
        return get(uri, ContentType.JSON);
    }
}
