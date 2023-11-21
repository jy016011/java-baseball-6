package baseball.controller;

import baseball.service.GameService;
import baseball.views.InputView;
import baseball.views.OutputView;

public class NumberBaseBall {
    private static final int RUNNING = 1;
    private static final int MAX_STRIKES = 3;
    private GameService gameService;

    public void init() {
        gameService = new GameService();
        gameService.setStatus();
    }

    public void run() {
        OutputView.printStartMessage();
        gameService.setComputerNumbers();
        while (gameService.getStatus() == RUNNING) {
            setUserNumbers();
            printResult();
            checkGameStatus();
        }
    }

    private void setUserNumbers() {
        String userInput = InputView.getUserNumbers();
        gameService.setUserNumbers(userInput);
    }

    private void printResult() {
        OutputView.printScore(gameService.getScores());
    }

    private void checkGameStatus() {
        if (gameService.getStrikeCount() == MAX_STRIKES) {
            OutputView.printEndMessage();
            String userInput = InputView.getRestartInput();
            gameService.resetStatus(userInput);
            gameService.setComputerNumbers();
        }
    }
}
