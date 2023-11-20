package baseball.service;

import baseball.constants.Score;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.User;
import baseball.utils.ArgumentValidator;
import baseball.utils.RandomGenerator;
import baseball.utils.StringChanger;
import java.util.Map;

public class GameService {
    private final static int LENGTH_OF_NUMBERS = 3;
    private final static int RUNNING = 1;
    private final static int RESTART = RUNNING;
    private final static int END = 2;
    private final static int NONE = 0;

    private final User user = new User();
    private final Computer computer = new Computer();
    private final Referee referee = new Referee();
    private int status;

    public void setStatus() {
        status = RUNNING;
    }

    public void setComputerNumbers() {
        computer.setNumbers(RandomGenerator.pickNumbersInRange(LENGTH_OF_NUMBERS));
    }

    public void setUserNumbers(String userInput) {
        user.setNumbers(userInput);
    }

    public int getStatus() {
        return status;
    }

    public Map<Score, Integer> getScores() {
        return referee.getScores(user, computer);
    }

    public int getStrikeCount() {
        Map<Score, Integer> scores = referee.getScores(user, computer);
        if (scores.containsKey(Score.STRIKE)) {
            return scores.get(Score.STRIKE);
        }
        return NONE;
    }

    public void resetStatus(String userInput) {
        int restartFactor = StringChanger.toInteger(userInput);
        validateRestartInput(restartFactor);
        status = restartFactor;
    }

    private void validateRestartInput(int restartFactor) {
        ArgumentValidator.isNotLessThan(restartFactor, RESTART);
        ArgumentValidator.isNotGreaterThan(restartFactor, END);
    }
}
