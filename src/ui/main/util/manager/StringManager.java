package src.ui.main.util.manager;

import org.openqa.selenium.InvalidArgumentException;

import java.util.List;
import java.util.regex.Matcher;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;
import static src.ui.main.util.constans.CommonFailMessageConstants.REGEX_MISMATCH_EXCEPTION_MESSAGE;

public final class StringManager {

    protected static Number getFirstMatchFromRegex(String text, String regex) {
        String errorMessage = format(REGEX_MISMATCH_EXCEPTION_MESSAGE, text, regex);
        Matcher matcher = compile(regex).matcher(text);
        if (matcher.find()) {
            return parseDouble(matcher.group());
        } else {
            throw new InvalidArgumentException(errorMessage);
        }
    }

    public static Number getSumDouble(List<String> values, String regex) {
        return values.stream()
                .map(value -> getFirstMatchFromRegex(value, regex))
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}
