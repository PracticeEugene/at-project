package src.api.main.modal;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

import java.util.List;

import static src.api.main.util.constant.CommonApiConstants.INVALID_VALUE;

@With
@Getter
@Builder(toBuilder = true)
public class ApiModels {

    private String wizardId;
    private String spellName;
    private String incantation;
    private String effect;
    private Boolean canBeVerbal;
    private String type;
    private String light;
    private String creator;
    private List<Object> elixirs;
    private String wizardFirstName;
    private String wizardLastName;
    private String elixirId;
    private String elixirName;

    public static ApiModels getAccioSpellModel() {
        return ApiModels.builder()
                .wizardId("77cead53-30ae-48a9-a118-e3d3df5ffd57")
                .spellName("Summoning Charm")
                .incantation("Accio")
                .effect("Summons an object")
                .canBeVerbal(true)
                .type("Charm")
                .light("Transparent")
                .creator(null)
                .build();
    }

    public static ApiModels getInvalidIncantationValueSpellModel() {
        return getAccioSpellModel().withIncantation(INVALID_VALUE);
    }

    public static ApiModels getWizardModel() {
        return ApiModels.builder()
                .wizardId("30bd3b76-57f0-4a25-be3b-41bbeccae927")
                .wizardFirstName("Fleamont")
                .wizardLastName("Potter")
                .build();
    }

    public static ApiModels getInvalidIdWizardModel() {
        return getWizardModel().withWizardId(INVALID_VALUE);
    }

    public static ApiModels getElixirModel() {
        return ApiModels.builder()
                .wizardId("30bd3b76-57f0-4a25-be3b-41bbeccae927")
                .elixirId("130a341b-8544-4ebf-bff6-ca83082d9853")
                .elixirName("Sleekeazy's Hair Potion")
                .build();
    }
}
