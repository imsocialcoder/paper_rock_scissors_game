package com.imc.input.round;

/**
 * An interface for classes responsible for handling input related to the number of rounds in the game.
 * Implementing classes should provide a way to obtain the number of rounds to be played in the game.
 */
public interface RoundInputHandler {

    /**
     * Retrieves the number of rounds from the user or another data source.
     *
     * @return The number of rounds to be played in the game.
     */
    int getNumberOfRounds();
}
