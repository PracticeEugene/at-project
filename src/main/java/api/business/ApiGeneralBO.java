package api.business;

import api.validator.ValidatorStorage;
import api.service.Service;

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
