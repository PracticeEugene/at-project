package src.api.test;

import org.testng.annotations.Test;

import static src.api.main.modal.ApiModels.*;
import static src.api.main.modal.ApiModels.getInvalidIdWizardModel;

public class WizardTest extends BaseApiTest {

    @Test
    public void verifyWizardsFieldsPresent() {
        wizardBO.verifyWizardsResponseFieldsPresent();
    }

    @Test
    public void verifyWizardPresentById() {
        wizardBO.verifyWizardResponseFieldsPresentById(getWizardModel())
                .verifyWizardFieldsValues(getWizardModel())
                .verifyElixirFieldsValues(getElixirModel());
    }

    @Test
    public void verifySearchWizardByInvalidId() {
        wizardBO.verifyWizardResponseByInvalidId(getInvalidIdWizardModel());
    }
}
