package com.imc.player;

/**
 * Represents a player in a game.
 */
public abstract class Player {
    private final String name;
    protected int score;

    /**
     * Constructs a player with the given name and initial score.
     *
     * @param name  The name of the player.
     * @param score The initial score of the player.
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current score of the player.
     *
     * @return The current score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Increases the player's score.
     * The implementation of this method should be provided by subclasses.
     */
    public abstract void increaseScore();
}
