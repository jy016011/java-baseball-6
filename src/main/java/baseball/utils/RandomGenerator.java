package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private final static int NATURAL_RANGE_START = 1;
    private final static int NATURAL_RANGE_END = 9;

    private RandomGenerator() {
    }

    public static List<Integer> pickNumbersInRange(int size) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = pickNaturalNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static int pickNaturalNumber() {
        return Randoms.pickNumberInRange(NATURAL_RANGE_START, NATURAL_RANGE_END);
    }
}
