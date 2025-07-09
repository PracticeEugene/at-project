package api.business;

import api.modal.ApiModels;
import api.response.ElixirResponse;
import api.response.WizardResponse;
import api.util.Field;
import api.util.StatusCode;
import api.util.constant.ApiMessageConstants;
import api.util.constant.CommonApiConstants;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static java.util.Arrays.stream;

public class WizardBO extends ApiGeneralBO {

    @Step("Verify that Wizards fields present")
    public void verifyWizardsResponseFieldsPresent() {
        Response response = service.getAllWizards();
        WizardResponse[] wizardResponse = validatorStorage.responseValidator(response)
                .validateStatusCode(StatusCode.OK)
                .validateModelAndGet(response, WizardResponse[].class);

        stream(wizardResponse).forEach(wizard -> validatorStorage.responseDataValidator()
                .validateListEquality(getResponseFields(wizard), Field.getWizardFields()));
    }

    @Step("Verify that Wizard fields present by wizard ID: {model.wizardId}")
    public WizardBO verifyWizardResponseFieldsPresentById(ApiModels model) {
        WizardResponse wizardResponse = getWizardResponseById(model);
        validatorStorage.responseDataValidator()
                .validateListEquality(getResponseFields(wizardResponse), Field.getWizardFields());
        return this;
    }

    @Step("Verify Wizard fields values by wizard ID: {model.wizardId}")
    public WizardBO verifyWizardFieldsValues(ApiModels model) {
        WizardResponse wizardResponse = getWizardResponseById(model);
        List.of(wizardResponse).forEach(wizard -> {
            SoftAssertions softAssertions = new SoftAssertions();
            validatorStorage.responseDataValidator()
                    .validateListNotEmpty(wizard.getElixirs(), ApiMessageConstants.ELIXIR_NOT_FOUND_FAIL_MESSAGE)
                    .validateStringEquality(wizard.getId(), model.getWizardId())
                    .validateStringEquality(wizard.getFirstName(), model.getWizardFirstName())
                    .validateStringEquality(wizard.getLastName(), model.getWizardLastName());
            softAssertions.assertAll();
        });
        return this;
    }

    @Step("Verify Wizard elixir fields values by wizard ID: {model.wizardId}")
    public void verifyElixirFieldsValues(ApiModels model) {
        List<ElixirResponse> elixirResponse = getWizardResponseById(model).getElixirs();
        elixirResponse.forEach(elixir -> validatorStorage.responseDataValidator()
                .validateStringEquality(elixir.getId(), model.getElixirId())
                .validateStringEquality(elixir.getName(), model.getElixirName()));
    }

    @Step("Verify Wizard response by invalid ID: {model.wizardId}")
    public void verifyWizardResponseByInvalidId(ApiModels model) {
        String invalidIdErrorMessage = String.format(ApiMessageConstants.INVALID_VALUE_ERROR_MESSAGE, model.getWizardId());
        Response response = service.getWizardById(model.getWizardId());
        validatorStorage.responseValidator(response)
                .validateStatusCode(StatusCode.BAD_REQUEST)
                .validateJsonFieldValue(CommonApiConstants.ERRORS_KEY, invalidIdErrorMessage)
                .validateJsonFieldValue(CommonApiConstants.TITLE_KEY, ApiMessageConstants.VALIDATION_ERROR_MESSAGE);
    }

    @Step("Get Wizard response by ID: {model.wizardId}")
    private WizardResponse getWizardResponseById(ApiModels model) {
        Response response = service.getWizardById(model.getWizardId());
        return validatorStorage.responseValidator(response)
                .validateStatusCode(StatusCode.OK)
                .validateModelAndGet(response, WizardResponse.class);
    }
}
