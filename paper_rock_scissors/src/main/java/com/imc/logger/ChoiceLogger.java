package com.imc.logger;

import com.imc.choice.model.Choice;

/**
 * An interface for logging choices made in the Paper-Rock-Scissors game.
 * Implementing classes of this interface are responsible for logging choices made during the game.
 */
public interface ChoiceLogger {

    /**
     * Logs the specified choice.
     *
     * @param choice The choice to be logged.
     */
    void logChoice(Choice choice);
}
