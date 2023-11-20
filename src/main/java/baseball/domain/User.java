package baseball.domain;

import java.util.Collections;
import java.util.List;

public class User {
    private List<Integer> numbers;

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
