package api.service;

import api.util.StringManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.client.RestClient;

import static api.util.constant.EndpointConstants.*;

public class Service extends RestClient {
    public static final String API_BASE_URI = "https://wizard-world-api.herokuapp.com";

    public Response getAllWizards() {
        String uri = StringManager.joinEndpoints(API_BASE_URI, WIZARDS_ENDPOINT);
        return get(uri, ContentType.JSON);
    }

    public Response getSpellByQueryParameter(String queryParameter) {
        String uri = StringManager.joinEndpoints(API_BASE_URI, SPELLS_ENDPOINT, queryParameter);
        return get(uri, ContentType.JSON);
    }

    public Response getWizardById(String id) {
        String uri = StringManager.joinEndpoints(API_BASE_URI, WIZARDS_ENDPOINT, StringManager.getPathParam(id));
        return get(uri, ContentType.JSON);
    }
}
