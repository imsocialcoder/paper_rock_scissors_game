package com.imc.input.choice;

import com.imc.choice.model.Choice;

/**
 * An interface for handling user input to obtain a choice in the Paper-Rock-Scissors game.
 * Implementing classes should provide a method to retrieve the user's choice.
 */
public interface ChoiceInputHandler {

    /**
     * Retrieves the user's choice in the game.
     *
     * @return The Choice selected by the user.
     */
    Choice getUserChoice();
}
