package com.imc.input.round;

import org.slf4j.Logger;

import java.util.Scanner;

/**
 * Implementation of RoundInputHandler that interacts with the console to get the number of rounds.
 */
public class ConsoleRoundInputHandler implements RoundInputHandler {
    private final Scanner scanner;
    private final Logger logger;
    private static final String ROUND_INPUT_MSG = "How many rounds do you want to play? Please enter: ";
    private static final String INVALID_ROUND_MSG = "Invalid number of rounds! ";

    /**
     * Constructs a ConsoleRoundInputHandler with the specified Scanner and Logger.
     *
     * @param scanner The Scanner object for reading user input.
     * @param logger  The Logger object for logging messages.
     */
    public ConsoleRoundInputHandler(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.logger = logger;
    }

    /**
     * Prompts the user to input the number of rounds and returns it.
     *
     * @return The number of rounds entered by the user.
     */
    @Override
    public int getNumberOfRounds() {
        while (true) {
            logger.info(ROUND_INPUT_MSG);
            try {
                int numberOfRounds = Integer.parseInt(scanner.nextLine().trim());
                if (numberOfRounds > 0) {
                    return numberOfRounds;
                } else {
                    logger.info("Number of rounds has to be greater than 0!");
                }
            } catch (NumberFormatException e) {
                logger.error(INVALID_ROUND_MSG);
            }
        }
    }
}