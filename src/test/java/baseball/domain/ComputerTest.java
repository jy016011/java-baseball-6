package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @DisplayName("같은 수를 가지고 있으면 true일 것이다.")
    @Test
    void hasSameNumber() {
        Computer computer = new Computer();
        computer.setNumbers(List.of(1, 2, 3));
        assertThat(computer.contains(2)).isEqualTo(true);
    }

    @DisplayName("같은 수를 가지고 있지 않으면 false일 것이다.")
    @Test
    void hasNotSameNumber() {
        Computer computer = new Computer();
        computer.setNumbers(List.of(1, 2, 3));
        assertThat(computer.contains(4)).isEqualTo(false);
    }

    @DisplayName("같은 수를 같은 자리에 가지고 있으면 true일 것이다.")
    @Test
    void hasSameNumberAndSameIndex() {
        Computer computer = new Computer();
        computer.setNumbers(List.of(1, 2, 3));
        List<Integer> userNumbers = List.of(1, 2, 3);
        int index = 1;
        assertThat(computer.isSameIndex(userNumbers.get(index), index)).isEqualTo(true);
    }

    @DisplayName("같은 수를 다른 자리에 가지고 있으면 false일 것이다.")
    @Test
    void hasSameNumberAndNotSameIndex() {
        Computer computer = new Computer();
        computer.setNumbers(List.of(1, 2, 3));
        List<Integer> userNumbers = List.of(1, 3, 2);
        int index = 2;
        assertThat(computer.isSameIndex(userNumbers.get(index), index)).isEqualTo(false);
    }
}
