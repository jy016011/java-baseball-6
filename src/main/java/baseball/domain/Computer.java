package baseball.domain;

import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean isSameIndex(int number, int index) {
        return number == numbers.get(index);
    }
}
