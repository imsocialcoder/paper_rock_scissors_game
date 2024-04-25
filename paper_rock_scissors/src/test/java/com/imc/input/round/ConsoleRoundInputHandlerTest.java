package com.imc.input.round;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ConsoleRoundInputHandlerTest {
    private final Scanner scanner = Mockito.mock(Scanner.class);
    private final Logger logger = Mockito.mock(Logger.class);

    @Test
    void getNumberOfRoundsShouldReturnValidNumberOfRounds() {
        RoundInputHandler inputHandler = new ConsoleRoundInputHandler(scanner, logger);

        when(scanner.nextLine()).thenReturn("5");

        int numberOfRounds = inputHandler.getNumberOfRounds();

        verify(logger, times(1)).info("How many rounds do you want to play? Please enter: ");
        verify(logger, times(0)).error("Invalid number of rounds! ");

        assertEquals(5, numberOfRounds);
    }

    @Test
    void getNumberOfRoundsShouldHandleInvalidInput() {
        RoundInputHandler inputHandler = new ConsoleRoundInputHandler(scanner, logger);

        when(scanner.nextLine()).thenReturn("invalid").thenReturn("10");

        int numberOfRounds = inputHandler.getNumberOfRounds();

        verify(logger, times(2)).info("How many rounds do you want to play? Please enter: ");
        verify(logger, times(1)).error("Invalid number of rounds! ");

        assertEquals(10, numberOfRounds);
    }

    @Test
    void getNumberOfRoundsShouldHandleZeroRoundsInput() {
        RoundInputHandler inputHandler = new ConsoleRoundInputHandler(scanner, logger);

        when(scanner.nextLine()).thenReturn("0").thenReturn("20");

        int numberOfRounds = inputHandler.getNumberOfRounds();

        verify(logger, times(2)).info("How many rounds do you want to play? Please enter: ");
        verify(logger, times(1)).info("Number of rounds has to be greater than 0!");

        assertEquals(20, numberOfRounds);
    }
}
