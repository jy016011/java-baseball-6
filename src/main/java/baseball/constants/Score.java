package baseball.constants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Score {
    NOTHING(false, false, "낫싱"),
    BALL(true, false, "볼"),
    STRIKE(true, true, "스트라이크");

    private final boolean contains;
    private final boolean isSameIndex;
    private final String message;

    Score(boolean contains, boolean isSameIndex, String message) {
        this.contains = contains;
        this.isSameIndex = isSameIndex;
        this.message = message;
    }

    public static Score getScore(boolean contains, boolean isSameIndex) {
        return Arrays.stream(Score.values())
                .filter(score -> score.contains == contains && score.isSameIndex == isSameIndex)
                .findFirst()
                .orElse(NOTHING);
    }

    public static List<String> getScoreMessagesBy(Map<Score, Integer> scoreDetails) {
        if (scoreDetails.keySet().stream().allMatch(score -> score == NOTHING)) {
            return List.of(NOTHING.getMessage());
        }
        return Arrays.stream(values()).filter(score -> score != NOTHING && scoreDetails.containsKey(score))
                .map(score -> String.format("%d" + score.message, scoreDetails.get(score)))
                .collect(Collectors.toList());
    }

    public String getMessage() {
        return message;
    }
}
