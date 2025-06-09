package ui.util.performer;

import ui.util.validator.BooleanValidator;
import ui.util.validator.CollectionsValidator;
import ui.util.validator.TextValidator;

public class ValidationPerformer {
    protected TextValidator textValidator = new TextValidator();
    protected BooleanValidator booleanValidator = new BooleanValidator();
    protected CollectionsValidator collectionsValidator = new CollectionsValidator();
}
