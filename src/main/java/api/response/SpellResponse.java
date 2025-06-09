package api.response;

import lombok.Data;

@Data
public class SpellResponse {

    private String id;
    private String name;
    private String incantation;
    private String effect;
    private Boolean canBeVerbal;
    private String type;
    private String light;
    private String creator;
}

