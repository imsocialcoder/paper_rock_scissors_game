package com.imc.round;

import com.imc.choice.model.Choice;
import com.imc.input.choice.ChoiceInputHandler;
import com.imc.logger.ChoiceLogger;
import com.imc.score.updater.ScoreUpdater;
import com.imc.score.writer.ScoreWriter;
import com.imc.choice.generator.ChoiceGenerator;

/**
 * Manages the rounds in a Paper-Rock-Scissors game.
 */
public class PaperRockScissorsRoundManager implements RoundManager {

    private final ChoiceGenerator choiceGenerator;
    private final ChoiceInputHandler choiceInputHandler;
    private final ScoreUpdater scoreUpdater;
    private final ScoreWriter scoreWriter;
    private final ChoiceLogger choiceLogger;

    // Private constructor to enforce instantiation through builder
    private PaperRockScissorsRoundManager(Builder builder) {
        this.choiceGenerator = builder.choiceGenerator;
        this.choiceInputHandler = builder.choiceInputHandler;
        this.scoreUpdater = builder.scoreUpdater;
        this.scoreWriter = builder.scoreWriter;
        this.choiceLogger = builder.choiceLogger;
    }

    /**
     * Plays the specified number of rounds in the game.
     *
     * @param numberOfRounds The number of rounds to play.
     */
    @Override
    public void playRounds(int numberOfRounds) {
        int roundsPlayed = 0;

        while (roundsPlayed < numberOfRounds) {
            Choice computerChoice = choiceGenerator.makeChoice();
            Choice userChoice = choiceInputHandler.getUserChoice();
            choiceLogger.logChoice(computerChoice);
            scoreUpdater.updateScore(userChoice, computerChoice);
            scoreWriter.writeScore();
            roundsPlayed++;
        }
    }

    /**
     * Builder class for constructing PaperRockScissorsRoundManager instances.
     */
    public static class Builder {
        private ChoiceGenerator choiceGenerator;
        private ChoiceInputHandler choiceInputHandler;
        private ScoreUpdater scoreUpdater;
        private ScoreWriter scoreWriter;
        private ChoiceLogger choiceLogger;

        public Builder withChoiceGenerator(ChoiceGenerator choiceGenerator) {
            this.choiceGenerator = choiceGenerator;
            return this;
        }

        public Builder withChoiceInputHandler(ChoiceInputHandler choiceInputHandler) {
            this.choiceInputHandler = choiceInputHandler;
            return this;
        }

        public Builder withScoreUpdater(ScoreUpdater scoreUpdater) {
            this.scoreUpdater = scoreUpdater;
            return this;
        }

        public Builder withScoreWriter(ScoreWriter scoreWriter) {
            this.scoreWriter = scoreWriter;
            return this;
        }

        public Builder withChoiceLogger(ChoiceLogger choiceLogger) {
            this.choiceLogger = choiceLogger;
            return this;
        }

        /**
         * Builds and returns a new PaperRockScissorsRoundManager instance.
         *
         * @return A new PaperRockScissorsRoundManager instance.
         */
        public PaperRockScissorsRoundManager build() {
            return new PaperRockScissorsRoundManager(this);
        }
    }
}
