package baseball.views;

import baseball.constants.Score;
import java.util.List;
import java.util.Map;

public class OutputView {
    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printScore(Map<Score, Integer> scoreDetails) {
        List<String> messages = Score.getScoreMessagesBy(scoreDetails);
        StringBuilder readableForm = new StringBuilder();
        for (String message : messages) {
            readableForm.append(message).append(" ");
        }
        System.out.println(readableForm);
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
