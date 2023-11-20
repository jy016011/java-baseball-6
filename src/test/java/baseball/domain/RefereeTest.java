package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constants.Score;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    @DisplayName("User의 수가 123, Computer의 수가 123이면 3스트라이크일 것이다.")
    @Test
    void testThreeStrikes() {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee();
        user.setNumbers("123");
        computer.setNumbers(List.of(1, 2, 3));
        Map<Score, Integer> scoreDetails = referee.getScores(user, computer);
        assertThat(scoreDetails.containsKey(Score.STRIKE)).isEqualTo(true);
        assertThat(scoreDetails.containsKey(Score.BALL)).isEqualTo(false);
        assertThat(scoreDetails.containsKey(Score.NOTHING)).isEqualTo(false);
        assertThat(scoreDetails.get(Score.STRIKE)).isEqualTo(3);
    }

    @DisplayName("User의 수가 345, Computer의 수가 123이면 1볼, 낫싱이 2개일 것이다.")
    @Test
    void testOneBall() {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee();
        user.setNumbers("345");
        computer.setNumbers(List.of(1, 2, 3));
        Map<Score, Integer> scoreDetails = referee.getScores(user, computer);
        assertThat(scoreDetails.containsKey(Score.STRIKE)).isEqualTo(false);
        assertThat(scoreDetails.containsKey(Score.BALL)).isEqualTo(true);
        assertThat(scoreDetails.containsKey(Score.NOTHING)).isEqualTo(true);
        assertThat(scoreDetails.get(Score.BALL)).isEqualTo(1);
        assertThat(scoreDetails.get(Score.NOTHING)).isEqualTo(2);
    }

    @DisplayName("User의 수가 456, Computer의 수가 123이면 3낫싱일 것이다.")
    @Test
    void testNothing() {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee();
        user.setNumbers("456");
        computer.setNumbers(List.of(1, 2, 3));
        Map<Score, Integer> scoreDetails = referee.getScores(user, computer);
        assertThat(scoreDetails.containsKey(Score.STRIKE)).isEqualTo(false);
        assertThat(scoreDetails.containsKey(Score.BALL)).isEqualTo(false);
        assertThat(scoreDetails.containsKey(Score.NOTHING)).isEqualTo(true);
        assertThat(scoreDetails.get(Score.NOTHING)).isEqualTo(3);
    }
}
