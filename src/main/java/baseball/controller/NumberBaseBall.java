package baseball.controller;

import baseball.constants.Score;
import baseball.service.GameService;
import baseball.utils.StringChanger;
import baseball.views.InputView;
import baseball.views.OutputView;
import java.util.Map;

public class NumberBaseBall {
    private static final int RUNNING = 1;
    private static final int MAX_STRIKES = 3;
    private GameService gameService;
    private int gameStatus;

    public void init() {
        gameService = new GameService();
        gameStatus = RUNNING;
    }

    public void run() {
        OutputView.printStartMessage();
        setComputerNumbers();
        while (gameStatus == RUNNING) {
            String userInput = InputView.getUserNumbers();
            gameService.setUserNumbers(userInput);
            Map<Score, Integer> scores = gameService.getScores();
            OutputView.printScore(scores);
            checkGameStatus(scores);
        }
    }

    private void checkGameStatus(Map<Score, Integer> scores) {
        if (scores.containsKey(Score.STRIKE) && scores.get(Score.STRIKE) == MAX_STRIKES) {
            OutputView.printEndMessage();
            String userInput = InputView.getRestartInput();
            int restartFactor = StringChanger.toInteger(userInput);
            gameService.validateRestartInput(restartFactor);
            gameStatus = restartFactor;
            setComputerNumbers();
        }
    }

    private void setComputerNumbers() {
        if (gameStatus == RUNNING) {
            gameService.setComputerNumbers();
        }
    }
}
