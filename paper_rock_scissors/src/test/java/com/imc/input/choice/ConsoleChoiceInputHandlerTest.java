package com.imc.input.choice;

import com.imc.choice.model.Choice;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ConsoleChoiceInputHandlerTest {
    private final Scanner scanner = Mockito.mock(Scanner.class);
    private final Logger logger = Mockito.mock(Logger.class);

    @Test
    void getUserChoiceShouldReturnRock() {
        ChoiceInputHandler inputHandler = new ConsoleChoiceInputHandler(scanner, logger);

        Mockito.when(scanner.nextLine()).thenReturn("rock");

        Choice choice = inputHandler.getUserChoice();

        verify(logger, times(1)).info("Make your move (paper / rock / scissors): ");
        verify(logger, Mockito.never()).error("Invalid move!");
        assertEquals(Choice.ROCK, choice);
    }

    @Test
    void getUserChoiceShouldReturnPaper() {
        ChoiceInputHandler inputHandler = new ConsoleChoiceInputHandler(scanner, logger);

        Mockito.when(scanner.nextLine()).thenReturn("paper");

        Choice choice = inputHandler.getUserChoice();

        verify(logger, times(1)).info("Make your move (paper / rock / scissors): ");
        verify(logger, Mockito.never()).error("Invalid move!");
        assertEquals(Choice.PAPER, choice);
    }

    @Test
    void getUserChoiceShouldReturnScissors() {
        ChoiceInputHandler inputHandler = new ConsoleChoiceInputHandler(scanner, logger);

        Mockito.when(scanner.nextLine()).thenReturn("scissors");

        Choice choice = inputHandler.getUserChoice();

        verify(logger, times(1)).info("Make your move (paper / rock / scissors): ");
        verify(logger, Mockito.never()).error("Invalid move!");
        assertEquals(Choice.SCISSORS, choice);
    }

    @Test
    void getUserChoiceShouldThrowExceptionForInvalidInputWhenNoFurtherInput() {
        ChoiceInputHandler inputHandler = new ConsoleChoiceInputHandler(scanner, logger);

        Mockito.when(scanner.nextLine()).thenReturn("invalid").thenReturn("paper");

        Choice choice = inputHandler.getUserChoice();

        verify(logger, times(2)).info("Make your move (paper / rock / scissors): ");
        verify(logger, times(1)).error("Invalid move!");
        assertEquals(Choice.PAPER, choice);
    }
}
