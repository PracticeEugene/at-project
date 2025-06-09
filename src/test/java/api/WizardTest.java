package api;

import org.testng.annotations.Test;

import static api.modal.ApiModels.getElixirModel;
import static api.modal.ApiModels.getInvalidIdWizardModel;
import static api.modal.ApiModels.getWizardModel;

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
