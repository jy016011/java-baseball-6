package baseball;

import baseball.controller.NumberBaseBall;

public class Application {
    public static void main(String[] args) {
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        numberBaseBall.init();
        numberBaseBall.run();
    }
}
