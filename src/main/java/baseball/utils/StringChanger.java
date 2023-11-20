package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {
    private StringChanger() {
    }

    public static List<Integer> toIntegerList(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .map(StringChanger::toInteger)
                .collect(Collectors.toList());
    }

    public static int toInteger(String input) {
        ArgumentValidator.isNumber(input);
        return Integer.parseInt(input);
    }
}
