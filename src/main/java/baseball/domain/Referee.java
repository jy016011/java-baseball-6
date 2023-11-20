package baseball.domain;

import baseball.constants.Score;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private static final int COUNT_ONE = 1;

    public Map<Score, Integer> getScores(User user, Computer computer) {
        List<Integer> userNumbers = user.getNumbers();
        Map<Score, Integer> scoreDetails = new HashMap<>();
        for (int index = 0; index < userNumbers.size(); index++) {
            int userNumber = userNumbers.get(index);
            Score score = getEachScore(userNumber, index, computer);
            recordScore(scoreDetails, score);
        }
        return Collections.unmodifiableMap(scoreDetails);
    }

    private Score getEachScore(int userNumber, int index, Computer computer) {
        boolean contains = computer.contains(userNumber);
        boolean isSameIndex = computer.isSameIndex(userNumber, index);
        return Score.getScore(contains, isSameIndex);
    }

    private void recordScore(Map<Score, Integer> scoreDetails, Score score) {
        if (scoreDetails.containsKey(score)) {
            scoreDetails.put(score, scoreDetails.get(score) + COUNT_ONE);
            return;
        }
        scoreDetails.put(score, COUNT_ONE);
    }
}
