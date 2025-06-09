package src.api.test;

import src.api.main.business.SpellBO;
import src.api.main.business.WizardBO;

public class BaseApiTest {

    protected final WizardBO wizardBO = new WizardBO();
    protected final SpellBO spellBO = new SpellBO();
}
