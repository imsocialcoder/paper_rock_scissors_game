package com.imc.score.writer;

import com.imc.player.Player;
import org.slf4j.Logger;

/**
 * A score writer implementation for the Paper-Rock-Scissors game.
 */
public class PaperRockScissorsScoreWriter implements ScoreWriter {
    private final Player user;
    private final Player computer;
    private final Logger logger;

    /**
     * Constructs a score writer for the Paper-Rock-Scissors game with the specified logger.
     *
     * @param user     The player "user".
     * @param computer The player "computer".
     * @param logger   The logger instance to be used for logging.
     */
    public PaperRockScissorsScoreWriter(Player user, Player computer, Logger logger) {
        this.user = user;
        this.computer = computer;
        this.logger = logger;
    }

    /**
     * Writes the current scores of the players.
     */
    @Override
    public void writeScore() {
        String score = "\nScore\n" +
                "-------------\n" +
                String.format("%-10s: %d\n", user.getName(), user.getScore()) +
                String.format("%-10s: %d\n", computer.getName(), computer.getScore()) +
                "-------------\n";
        logger.info(score);
    }
}
