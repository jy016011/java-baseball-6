package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    @DisplayName("입력이 세자리가 아닌경우"
            + "입력이 모두 숫자가 아닌경우"
            + "중복된 숫자가 있는 경우"
            + "각 자리 수중 하나라도 1이상 9이하가 아닌경우"
            + "예외가 발생할 것이다.")
    @ValueSource(strings = {"12", "12b", "112", "120"})
    @ParameterizedTest
    void setInvalidUserNumber(String userInput) {
        User user = new User();
        assertThatThrownBy(() -> user.setNumbers(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 입력일 경우 예외 안뜰 것이다.")
    @Test
    void setValidUserNumber() {
        User user = new User();
        assertThatCode(() -> user.setNumbers("123")).doesNotThrowAnyException();
    }
}
