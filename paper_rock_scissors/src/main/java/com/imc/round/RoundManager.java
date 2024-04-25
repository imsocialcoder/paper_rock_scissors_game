package com.imc.round;

/**
 * An interface representing a manager for handling rounds in a game.
 * Implementing classes are responsible for managing the gameplay mechanics of rounds.
 */
public interface RoundManager {

    /**
     * Plays the specified number of rounds in the game.
     *
     * @param numberOfRounds The number of rounds to play.
     */
    void playRounds(int numberOfRounds);
}
