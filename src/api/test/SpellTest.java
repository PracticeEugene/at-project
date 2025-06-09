package src.api.test;

import org.testng.annotations.Test;

import static src.api.main.modal.ApiModels.*;

public class SpellTest extends BaseApiTest {

    @Test
    public void verifySpellPresentByIncantation() {
        spellBO.verifySpellResponseFieldsPresentByIncantation(getAccioSpellModel())
                .verifySpellFieldsValues(getAccioSpellModel());
    }

    @Test
    public void verifySearchSpellByInvalidIncantationValue() {
        spellBO.verifySpellResponseByInvalidIncantationValue(getInvalidIncantationValueSpellModel());
    }
}