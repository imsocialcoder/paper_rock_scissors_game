package com.imc.logger;

import com.imc.choice.model.Choice;
import com.imc.player.Player;
import org.slf4j.Logger;

/**
 * A choice logger implementation specific to the Paper-Rock-Scissors game.
 * This logger logs the choices made by a player during the game.
 */
public class PaperRockScissorsChoiceLogger implements ChoiceLogger {
    private final Logger logger;
    private final Player player;

    /**
     * Constructs a PaperRockScissorsChoiceLogger for the specified player and logger.
     *
     * @param player The player whose choices will be logged.
     * @param logger The logger instance to be used for logging.
     */
    public PaperRockScissorsChoiceLogger(Player player, Logger logger) {
        this.player = player;
        this.logger = logger;
    }

    /**
     * Logs the specified choice made by the player.
     *
     * @param choice The choice made by the player.
     */
    @Override
    public void logChoice(Choice choice) {
        logger.info("{}: {}", player.getName(), choice);
    }
}
