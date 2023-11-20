package baseball.views;

import baseball.constants.Score;
import java.util.Map;

public class OutputView {
    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printScore(Map<Score, Integer> scoreDetails) {
        StringBuilder readableForm = new StringBuilder();
        if (!scoreDetails.containsKey(Score.STRIKE) && !scoreDetails.containsKey(Score.BALL)) {
            readableForm.append(Score.NOTHING.getMessage());
        }
        if (scoreDetails.containsKey(Score.BALL)) {
            readableForm.append(scoreDetails.get(Score.BALL))
                    .append(Score.BALL.getMessage()).append(" ");
        }
        if (scoreDetails.containsKey(Score.STRIKE)) {
            readableForm.append(scoreDetails.get(Score.STRIKE))
                    .append(Score.STRIKE.getMessage());
        }
        System.out.println(readableForm);
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
