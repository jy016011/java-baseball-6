package baseball.service;

import baseball.constants.Score;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.User;
import baseball.utils.ArgumentValidator;
import baseball.utils.RandomGenerator;
import java.util.Map;

public class GameService {
    private final static int LENGTH_OF_NUMBERS = 3;
    private final static int RESTART = 1;
    private final static int END = 2;

    private final User user = new User();
    private final Computer computer = new Computer();
    private final Referee referee = new Referee();

    public void setComputerNumbers() {
        computer.setNumbers(RandomGenerator.pickNumbersInRange(LENGTH_OF_NUMBERS));
    }

    public void setUserNumbers(String userInput) {
        user.setNumbers(userInput);
    }

    public Map<Score, Integer> getScores() {
        return referee.getScores(user, computer);
    }

    public void validateRestartInput(int restartFactor) {
        ArgumentValidator.isNotLessThan(restartFactor, RESTART);
        ArgumentValidator.isNotGreaterThan(restartFactor, END);
    }
}
