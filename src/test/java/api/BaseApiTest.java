package api;

import api.business.SpellBO;
import api.business.WizardBO;

public class BaseApiTest {

    protected final WizardBO wizardBO = new WizardBO();
    protected final SpellBO spellBO = new SpellBO();
}
