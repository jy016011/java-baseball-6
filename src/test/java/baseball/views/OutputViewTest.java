package baseball.views;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constants.Score;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void reset() {
        System.setOut(standardOut);
        captor.reset();
    }

    private String output() {
        return captor.toString().trim();
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    void oneBallOneStrike() {
        Map<Score, Integer> scoreDetails = new HashMap<>();
        scoreDetails.put(Score.BALL, 1);
        scoreDetails.put(Score.STRIKE, 1);
        scoreDetails.put(Score.NOTHING, 1);
        OutputView.printScore(scoreDetails);
        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("3스트라이크")
    @Test
    void threeStrike() {
        Map<Score, Integer> scoreDetails = new HashMap<>();
        scoreDetails.put(Score.STRIKE, 3);
        OutputView.printScore(scoreDetails);
        assertThat(output()).isEqualTo("3스트라이크");
    }

    @DisplayName("3볼")
    @Test
    void threeBall() {
        Map<Score, Integer> scoreDetails = new HashMap<>();
        scoreDetails.put(Score.BALL, 3);
        OutputView.printScore(scoreDetails);
        assertThat(output()).isEqualTo("3볼");
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        Map<Score, Integer> scoreDetails = new HashMap<>();
        scoreDetails.put(Score.NOTHING, 3);
        OutputView.printScore(scoreDetails);
        assertThat(output()).isEqualTo("낫싱");
    }
}
