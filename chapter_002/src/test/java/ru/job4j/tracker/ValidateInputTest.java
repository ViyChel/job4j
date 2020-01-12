package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    private ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private PrintStream out = System.out;

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void backOutput() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidKeyMenuInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"-1", "0"})
        );
        input.askInt("Enter", 1);
        assertThat(
                mem.toString(),
                is(String.format("Please select key from menu %n"))
        );
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.askInt("Enter", 2);
        assertThat(
                mem.toString(),
                is(String.format("Please enter validate data again %n"))
        );
    }
}

