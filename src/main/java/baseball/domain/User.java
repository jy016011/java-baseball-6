package baseball.domain;

import baseball.utils.ArgumentValidator;
import baseball.utils.StringChanger;
import java.util.Collections;
import java.util.List;

public class User {
    private final static String SEPARATOR = "";

    private final static int VALID_LENGTH = 3;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
    private List<Integer> numbers;

    public void setNumbers(String userInput) {
        numbers = toNumbers(userInput);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> toNumbers(String userInput) {
        ArgumentValidator.isEqual(userInput.length(), VALID_LENGTH);
        List<Integer> numbers = StringChanger.toIntegerList(userInput, SEPARATOR);
        ArgumentValidator.isUniqueNumbers(numbers);
        for (int number : numbers) {
            validateRange(number);
        }
        return numbers;
    }

    private void validateRange(int number) {
        ArgumentValidator.isNotLessThan(number, MIN_NUMBER);
        ArgumentValidator.isNotGreaterThan(number, MAX_NUMBER);
    }

}
