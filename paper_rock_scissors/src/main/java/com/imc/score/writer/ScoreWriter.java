package com.imc.score.writer;

/**
 * An interface for writing scores in a game.
 * Implementing classes should provide functionality to write scores.
 */
public interface ScoreWriter {

    /**
     * Writes the current score of the game.
     */
    void writeScore();
}
