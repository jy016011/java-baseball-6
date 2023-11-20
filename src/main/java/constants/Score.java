package constants;

import java.util.Arrays;

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

    public String getMessage() {
        return message;
    }
}
