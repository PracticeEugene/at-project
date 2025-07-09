package api;

import org.testng.annotations.Test;

import static api.modal.ApiModels.getElixirModel;
import static api.modal.ApiModels.getInvalidIdWizardModel;
import static api.modal.ApiModels.getWizardModel;

public class WizardTest extends BaseApiTest {

    @Test(description = "Verify search Wizards")
    public void verifyWizardsFieldsPresent() {
        wizardBO.verifyWizardsResponseFieldsPresent();
    }


    @Test(description = "Verify search Wizards by ID")
    public void verifyWizardPresentById() {
        wizardBO.verifyWizardResponseFieldsPresentById(getWizardModel())
                .verifyWizardFieldsValues(getWizardModel())
                .verifyElixirFieldsValues(getElixirModel());
    }

    @Test(description = "Verify search Wizards with invalid ID")
    public void verifySearchWizardByInvalidId() {
        wizardBO.verifyWizardResponseByInvalidId(getInvalidIdWizardModel());
    }
}
