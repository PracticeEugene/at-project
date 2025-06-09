package api.response;

import lombok.Data;

import java.util.List;

@Data
public class WizardResponse {

    private List<ElixirResponse> elixirs;
    private String id;
    private String firstName;
    private String lastName;
}
