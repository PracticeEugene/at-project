package api;

import org.testng.annotations.Test;

import static api.modal.ApiModels.getAccioSpellModel;
import static api.modal.ApiModels.getInvalidIncantationValueSpellModel;

public class SpellTest extends BaseApiTest {

    @Test(description = "Verify search Spell by Incantation value")
    public void verifySpellPresentByIncantation() {
        spellBO.verifySpellResponseFieldsPresentByIncantation(getAccioSpellModel())
                .verifySpellFieldsValues(getAccioSpellModel());
    }

    @Test(description = "Verify search Spell with invalid Incantation value")
    public void verifySearchSpellByInvalidIncantationValue() {
        spellBO.verifySpellResponseByInvalidIncantationValue(getInvalidIncantationValueSpellModel());
    }
}