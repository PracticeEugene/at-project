package ui.util.uiBeanFactory;

import java.util.HashMap;
import java.util.Map;

public class UiBeanFactory {

    private static final Map<Class<?>, Object> beans = new HashMap<>();

    public static <T> T getBean(Class<T> clazz) {
        if (beans.containsKey(clazz)) {
            return clazz.cast(beans.get(clazz));
        }
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            registerBean(clazz, instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Could not create bean for class: " + clazz.getName(), e);
        }
    }

    public static <T> void registerBean(Class<T> clazz, T instance) {
        beans.put(clazz, instance);
    }
}
