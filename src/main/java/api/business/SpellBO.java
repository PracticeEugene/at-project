package api.business;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import api.modal.ApiModels;
import api.response.SpellResponse;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static api.util.Field.getSpellFields;
import static api.util.StatusCode.OK;
import static api.util.constant.QueryParametersConstants.GENERIC_INCANTATION_QUERY_PARAM;

public class SpellBO extends ApiGeneralBO {

    @Step("Verify that Spell fields present by Incantation value: {model.incantation}")
    public SpellBO verifySpellResponseFieldsPresentByIncantation(ApiModels model) {
        SpellResponse[] spellResponse = getSpellResponseByIncantation(model);
        stream(spellResponse).forEach(spell -> validatorStorage.responseDataValidator()
                .validateListEquality(getResponseFields(spell), getSpellFields()));
        return this;
    }

    @Step("Verify Spell fields values by Incantation value: {model.incantation}")
    public SpellBO verifySpellFieldsValues(ApiModels model) {
        SpellResponse[] spellResponse = getSpellResponseByIncantation(model);
        stream(spellResponse).forEach(spell -> {
            SoftAssertions softAssertions = new SoftAssertions();
            validatorStorage.responseDataValidator()
                    .validateStringEquality(spell.getId(), model.getWizardId())
                    .validateStringEquality(spell.getName(), model.getSpellName())
                    .validateStringEquality(spell.getIncantation(), model.getIncantation())
                    .validateStringEquality(spell.getEffect(), model.getEffect())
                    .validateTrueCondition(spell.getCanBeVerbal())
                    .validateStringEquality(spell.getLight(), model.getLight())
                    .validateStringEquality(spell.getCreator(), model.getCreator());
            softAssertions.assertAll();
        });
        return this;
    }

    @Step("Verify Spell response by invalid Incantation value: {model.incantation}")
    public SpellBO verifySpellResponseByInvalidIncantationValue(ApiModels model) {
        SpellResponse[] spellResponse = getSpellResponseByIncantation(model);
        stream(spellResponse).forEach(spell -> validatorStorage.responseDataValidator()
                .verifyEmptyList(getResponseFields(spell)));
        return this;
    }


    @Step("Get Spell response by Incantation value: {model.incantation}")
    private SpellResponse[] getSpellResponseByIncantation(ApiModels model) {
        String incantationQueryParameter = format(GENERIC_INCANTATION_QUERY_PARAM, model.getIncantation());
        Response response = service.getSpellByQueryParameter(incantationQueryParameter);
        return validatorStorage.responseValidator(response)
                .validateStatusCode(OK)
                .validateModelAndGet(response, SpellResponse[].class);
    }
}
