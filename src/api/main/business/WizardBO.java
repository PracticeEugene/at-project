package src.api.main.business;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import src.api.main.modal.ApiModels;
import src.api.main.response.ElixirResponse;
import src.api.main.response.WizardResponse;

import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static src.api.main.util.Field.getWizardFields;
import static src.api.main.util.StatusCode.BAD_REQUEST;
import static src.api.main.util.StatusCode.OK;
import static src.api.main.util.constant.ApiMessageConstants.*;
import static src.api.main.util.constant.CommonApiConstants.ERRORS_KEY;
import static src.api.main.util.constant.CommonApiConstants.TITLE_KEY;

public class WizardBO extends ApiGeneralBO {

    @Step("Verify that Wizards fields present")
    public void verifyWizardsResponseFieldsPresent() {
        Response response = service.getAllWizards();
        WizardResponse[] wizardResponse = validatorStorage.responseValidator(response)
                .validateStatusCode(OK)
                .validateModelAndGet(response, WizardResponse[].class);

        stream(wizardResponse).forEach(wizard -> validatorStorage.responseDataValidator()
                .validateListEquality(getResponseFields(wizard), getWizardFields()));
    }

    @Step("Verify that Wizard fields present by wizard ID: {model.id}")
    public WizardBO verifyWizardResponseFieldsPresentById(ApiModels model) {
        WizardResponse wizardResponse = getWizardResponseById(model);
        validatorStorage.responseDataValidator()
                .validateListEquality(getResponseFields(wizardResponse), getWizardFields());
        return this;
    }

    @Step("Verify Wizard fields values by wizard ID: {model.id}")
    public WizardBO verifyWizardFieldsValues(ApiModels model) {
        WizardResponse wizardResponse = getWizardResponseById(model);
        List.of(wizardResponse).forEach(wizard -> {
            SoftAssertions softAssertions = new SoftAssertions();
            validatorStorage.responseDataValidator()
                    .validateListNotEmpty(wizard.getElixirs(), ELIXIR_NOT_FOUND_FAIL_MESSAGE)
                    .validateStringEquality(wizard.getId(), model.getWizardId())
                    .validateStringEquality(wizard.getFirstName(), model.getWizardFirstName())
                    .validateStringEquality(wizard.getLastName(), model.getWizardLastName());
            softAssertions.assertAll();
        });
        return this;
    }

    @Step("Verify Wizard elixir fields values by wizard ID: {model.id}")
    public WizardBO verifyElixirFieldsValues(ApiModels model) {
        List<ElixirResponse> elixirResponse = getWizardResponseById(model).getElixirs();
        elixirResponse.forEach(elixir -> validatorStorage.responseDataValidator()
                .validateStringEquality(elixir.getId(), model.getElixirId())
                .validateStringEquality(elixir.getName(), model.getElixirName()));
        return this;
    }

    @Step("Verify Wizard response by invalid ID: {model.id}")
    public void verifyWizardResponseByInvalidId(ApiModels model) {
        String invalidIdErrorMessage = format(INVALID_VALUE_ERROR_MESSAGE, model.getWizardId());
        Response response = service.getWizardById(model.getWizardId());
        validatorStorage.responseValidator(response)
                .validateStatusCode(BAD_REQUEST)
                .validateJsonFieldValue(ERRORS_KEY, invalidIdErrorMessage)
                .validateJsonFieldValue(TITLE_KEY, VALIDATION_ERROR_MESSAGE);
    }

    @Step("Get Wizard response by ID: {model.id}")
    private WizardResponse getWizardResponseById(ApiModels model) {
        Response response = service.getWizardById(model.getWizardId());
        return validatorStorage.responseValidator(response)
                .validateStatusCode(OK)
                .validateModelAndGet(response, WizardResponse.class);
    }
}
