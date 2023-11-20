package baseball.domain;

import baseball.utils.ArgumentValidator;
import java.util.List;

public class Computer {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    private List<Integer> numbers;

    public void setNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean isSameIndex(int number, int index) {
        return number == numbers.get(index);
    }

    private void validate(List<Integer> numbers) {
        ArgumentValidator.isUniqueNumbers(numbers);
        for (int number : numbers) {
            ArgumentValidator.isNotLessThan(number, MIN_NUMBER);
            ArgumentValidator.isNotGreaterThan(number, MAX_NUMBER);
        }
    }
}
