package com.imc.score.updater;

import com.imc.choice.model.Choice;
import com.imc.player.Player;
import org.slf4j.Logger;

/**
 * Updates the scores in the Paper-Rock-Scissors game based on user and computer choices.
 */
public class PaperRockScissorsScoreUpdater implements ScoreUpdater {
    private final Player user;
    private final Player computer;
    private final Logger logger;

    /**
     * Constructs a PaperRockScissorsScoreUpdater with the specified players and logger.
     *
     * @param user     The player representing the user.
     * @param computer The player representing the computer.
     * @param logger   The logger for logging score updates.
     */
    public PaperRockScissorsScoreUpdater(Player user, Player computer, Logger logger) {
        this.user = user;
        this.computer = computer;
        this.logger = logger;
    }

    /**
     * Updates the scores based on the choices of the user and the computer.
     *
     * @param userChoice    The choice made by the player.
     * @param computerChoice The choice made by the computer.
     */
    @Override
    public void updateScore(Choice userChoice, Choice computerChoice) {
        if (userChoice.winsAgainst(computerChoice)) {
            logger.info("{} wins!", user.getName());
            user.increaseScore();
        } else if (computerChoice.winsAgainst(userChoice)) {
            logger.info("{} wins!", computer.getName());
            computer.increaseScore();
        } else {
            logger.info("Draw!");
        }
    }
}