package api.util;

import static java.lang.String.join;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public final class StringManager {

    public static String getPathParam(String pathParam) {
        return DECODED_SLASH + pathParam;
    }

    public static String joinEndpoints(String... endpoints) {
        return join(EMPTY, endpoints);
    }

    //CharConstants
    public static final String DECODED_SLASH = "/";
}
