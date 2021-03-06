package ru.job4j.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 01.02.2021
 */
@Component
@Scope("prototype")
public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
