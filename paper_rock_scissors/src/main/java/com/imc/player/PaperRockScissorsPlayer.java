package com.imc.player;

/**
 * Represents a player in the Paper-Rock-Scissors game.
 */
public class PaperRockScissorsPlayer extends Player {

    /**
     * Constructs a PaperRockScissorsPlayer with the given name and initial score of 0.
     *
     * @param name The name of the player.
     */
    public PaperRockScissorsPlayer(String name) {
        super(name, 0);
    }

    /**
     * Increases the player's score by 1.
     * Overrides the method defined in the superclass.
     */
    @Override
    public void increaseScore() {
        score++;
    }
}