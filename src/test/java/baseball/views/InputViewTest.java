package baseball.views;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void reset() {
        System.setOut(standardOut);
        captor.reset();
        Console.close();
    }

    private String output() {
        return captor.toString();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @DisplayName("유저의 숫자 입력받기")
    @Test
    void getUserNumbers() {
        String userInput = "321";
        command(userInput);
        String systemReceived = InputView.getUserNumbers();
        assertThat(output()).isEqualTo("숫자를 입력해주세요 : ");
        assertThat(systemReceived).isEqualTo(userInput);
    }
}
