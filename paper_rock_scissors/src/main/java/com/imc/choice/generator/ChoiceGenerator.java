package com.imc.choice.generator;

import com.imc.choice.model.Choice;

/**
 * An interface representing a generator for choices in the Paper-Rock-Scissors game.
 * Implementing classes should provide functionality to generate choices for computer players.
 */
public interface ChoiceGenerator {

    /**
     * Generates a choice for the computer player.
     *
     * @return The generated choice.
     */
    Choice makeChoice();
}
