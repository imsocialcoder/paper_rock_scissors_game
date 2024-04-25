package com.imc.input.choice;

import com.imc.choice.model.Choice;
import org.slf4j.Logger;

import java.util.Map;
import java.util.Scanner;

/**
 * Handles user input from the console to obtain a choice in the Paper-Rock-Scissors game.
 */
public class ConsoleChoiceInputHandler implements ChoiceInputHandler {
    private final Scanner scanner;
    private final Logger logger;
    private static final String MAKE_YOUR_MOVE_MSG = "Make your move (paper / rock / scissors): ";
    private static final String INVALID_MOVE_MSG = "Invalid move!";

    /**
     * A map containing choice names as keys and their corresponding Choice objects as values.
     */
    public static final Map<String, Choice> CHOICE_MAP = Map.of(
            "paper", Choice.PAPER,
            "rock", Choice.ROCK,
            "scissors", Choice.SCISSORS
    );

    /**
     * Constructs a ConsoleChoiceInputHandler with the specified Scanner and Logger.
     *
     * @param scanner The Scanner object for reading user input.
     * @param logger  The Logger object for logging messages.
     */
    public ConsoleChoiceInputHandler(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.logger = logger;
    }

    @Override
    public Choice getUserChoice() {
        while (true) {
            logger.info(MAKE_YOUR_MOVE_MSG);
            String userChoice = scanner.nextLine().trim().toLowerCase();
            if (CHOICE_MAP.containsKey(userChoice)) {
                return CHOICE_MAP.get(userChoice);
            } else {
                logger.error(INVALID_MOVE_MSG);
            }
        }
    }
}
