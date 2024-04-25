package com.imc.choice.generator;

import com.imc.choice.model.Choice;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A generator for random choices in the Paper-Rock-Scissors game.
 * This implementation randomly selects from the available choices: Paper, Rock, and Scissors.
 */
public class RandomChoiceGenerator implements ChoiceGenerator {
    private final Random random = ThreadLocalRandom.current();
    private final Choice[] choices = {Choice.PAPER, Choice.ROCK, Choice.SCISSORS};

    /**
     * Generates a random choice for the player.
     *
     * @return The randomly generated choice.
     */
    @Override
    public Choice makeChoice() {
        int index = random.nextInt(choices.length);
        return choices[index];
    }
}

