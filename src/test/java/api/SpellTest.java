package api;

import org.testng.annotations.Test;

import static api.modal.ApiModels.getAccioSpellModel;
import static api.modal.ApiModels.getInvalidIncantationValueSpellModel;

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