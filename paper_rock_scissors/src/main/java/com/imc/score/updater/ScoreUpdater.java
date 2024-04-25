package com.imc.score.updater;

import com.imc.choice.model.Choice;

/**
 * An interface for updating the scores in the Paper-Rock-Scissors game based on player and computer choices.
 * Implementing classes should provide the logic for updating the scores according to the game rules.
 */
public interface ScoreUpdater {

    /**
     * Updates the scores based on the player's and computer's choices.
     *
     * @param playerChoice   The choice made by the player.
     * @param computerChoice The choice made by the computer.
     */
    void updateScore(Choice playerChoice, Choice computerChoice);
}

