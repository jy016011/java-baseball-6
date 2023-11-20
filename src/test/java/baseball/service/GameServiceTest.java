package baseball.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameServiceTest {
    @DisplayName("컴퓨터의 세자리수는 항상 규칙에 맞는 수들일 것이다.")
    @Test
    void setComputerNumbersWithRandoms() {
        GameService gameService = new GameService();
        for (int i = 0; i < 1000; i++) {
            assertThatCode(gameService::setComputerNumbers).doesNotThrowAnyException();
        }
    }

    @DisplayName("재시작 입력이 1혹은 2가 아니면 예외가 발생할 것이다.")
    @ValueSource(strings = {"3", "12", "a", "-1", "-2", "", "0"})
    @ParameterizedTest
    void invalidRestartInput(String userInput) {
        GameService gameService = new GameService();
        assertThatThrownBy(() -> gameService.resetStatus(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 입력이 1혹은 2라면 예외가 발생하지 않을 것이다.")
    @ValueSource(strings = {"1", "2"})
    @ParameterizedTest
    void validRestartInput(String userInput) {
        GameService gameService = new GameService();
        assertThatCode(
                () -> gameService.resetStatus(userInput))
                .doesNotThrowAnyException();
    }
}
