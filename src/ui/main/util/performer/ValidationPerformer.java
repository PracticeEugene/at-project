package src.ui.main.util.performer;

import src.ui.main.util.validator.BooleanValidator;
import src.ui.main.util.validator.CollectionsValidator;
import src.ui.main.util.validator.TextValidator;

public class ValidationPerformer {
    protected TextValidator textValidator = new TextValidator();
    protected BooleanValidator booleanValidator = new BooleanValidator();
    protected CollectionsValidator collectionsValidator = new CollectionsValidator();
}
