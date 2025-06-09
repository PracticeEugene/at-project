package api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Field {

    ELIXIRS_FIELD("elixirs"),
    ID_FIELD("id"),
    FIRST_NAME_FIELD("firstName"),
    LAST_NAME_FIELD("lastName"),
    NAME_FIELD("name"),
    TYPE_FIELD("type"),
    EFFECT_FIELD("effect"),
    INCANTATION_FIELD("incantation"),
    CANBEVERBAL_FIELD("canBeVerbal"),
    LIGHT_FIELD("light"),
    CREATOR_FIELD("creator");

    private final String name;

    public static List<String> getWizardFields() {
        return Stream.of(ELIXIRS_FIELD, ID_FIELD, FIRST_NAME_FIELD, LAST_NAME_FIELD)
                .map(Field::getName)
                .toList();
    }

    public static List<String> getSpellFields() {
        return Stream.of(ID_FIELD, NAME_FIELD, INCANTATION_FIELD, EFFECT_FIELD, CANBEVERBAL_FIELD, TYPE_FIELD,
                        LIGHT_FIELD, CREATOR_FIELD)
                .map(Field::getName)
                .toList();
    }
}
