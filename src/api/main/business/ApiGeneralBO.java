package src.api.main.business;

import src.api.main.service.Service;
import src.api.main.validator.ValidatorStorage;

import java.lang.reflect.Field;
import java.util.List;

import static java.util.Arrays.stream;


public class ApiGeneralBO {
    protected final ValidatorStorage validatorStorage = new ValidatorStorage();

    protected final Service service = new Service();

    public static List<String> getResponseFields(Object object) {
        return stream(object.getClass().getDeclaredFields())
                .map(Field::getName)
                .toList();
    }
}
