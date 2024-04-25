package com.imc.gameinfo;

import com.imc.player.Player;
import com.imc.score.writer.ScoreWriter;
import org.slf4j.Logger;

/**
 * A class responsible for writing game information for a Paper-Rock-Scissors game.
 * This includes welcoming players and displaying the current score.
 */
public class PaperRockScissorsInfoWriter implements GameInfoWriter {
    private final Player user;
    private final Player computer;
    private final ScoreWriter scoreWriter;
    private final Logger logger;

    // Private constructor to enforce instantiation through builder
    private PaperRockScissorsInfoWriter(Builder builder) {
        this.user = builder.user;
        this.computer = builder.computer;
        this.scoreWriter = builder.scoreWriter;
        this.logger = builder.logger;
    }

    /**
     * Writes Paper-Rock-Scissors game information to the log.
     * This includes a welcome message and the current score.
     */
    @Override
    public void writeGameInfo() {
        logger.info("Welcome to Paper-Rock-ScissorsGame!");
        logger.info("Players are: {} and {}", user.getName(), computer.getName());
        scoreWriter.writeScore();
    }

    /**
     * Builder class for constructing PaperRockScissorsInfoWriter instances.
     */
    public static class Builder {
        private Player user;
        private Player computer;
        private ScoreWriter scoreWriter;
        private Logger logger;

        public Builder withUser(Player user) {
            this.user = user;
            return this;
        }

        public Builder withComputer(Player computer) {
            this.computer = computer;
            return this;
        }

        public Builder withScoreWriter(ScoreWriter scoreWriter) {
            this.scoreWriter = scoreWriter;
            return this;
        }

        public Builder withLogger(Logger logger) {
            this.logger = logger;
            return this;
        }

        /**
         * Builds and returns a new PaperRockScissorsInfoWriter instance.
         *
         * @return A new PaperRockScissorsInfoWriter instance.
         */
        public PaperRockScissorsInfoWriter build() {
            return new PaperRockScissorsInfoWriter(this);
        }
    }
}
