package com.imc.game;

import com.imc.gameinfo.GameInfoWriter;
import com.imc.input.round.RoundInputHandler;
import com.imc.round.RoundManager;

/**
 * Represents a Paper-Rock-Scissors game.
 */
public class PaperRockScissorsGame implements Game {
    private final RoundManager roundManager;
    private final GameInfoWriter gameInfoWriter;
    private final RoundInputHandler inputHandler;

    /**
     * Constructs a PaperRockScissorsGame with the given RoundManager, GameInfoWriter, and RoundInputHandler.
     *
     * @param roundManager  The RoundManager responsible for managing game rounds.
     * @param gameInfoWriter  The GameInfoWriter responsible for writing game information.
     * @param inputHandler  The RoundInputHandler responsible for handling round input.
     */
    private PaperRockScissorsGame(RoundManager roundManager, GameInfoWriter gameInfoWriter, RoundInputHandler inputHandler) {
        this.roundManager = roundManager;
        this.gameInfoWriter = gameInfoWriter;
        this.inputHandler = inputHandler;
    }

    /**
     * Starts playing the Paper-Rock-Scissors game.
     */
    @Override
    public void playGame() {
        gameInfoWriter.writeGameInfo();
        roundManager.playRounds(inputHandler.getNumberOfRounds());
    }

    /**
     * Builder class for constructing instances of PaperRockScissorsGame.
     */
    public static class PaperRockScissorsGameBuilder {
        private RoundManager roundManager;
        private GameInfoWriter gameInfoWriter;
        private RoundInputHandler inputHandler;

        public PaperRockScissorsGameBuilder withRoundManager(RoundManager roundManager) {
            this.roundManager = roundManager;
            return this;
        }

        public PaperRockScissorsGameBuilder withGameInfoWriter(GameInfoWriter gameInfoWriter) {
            this.gameInfoWriter = gameInfoWriter;
            return this;
        }

        public PaperRockScissorsGameBuilder withRoundInputHandler(RoundInputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        /**
         * Builds a new instance of PaperRockScissorsGame.
         *
         * @return A new instance of PaperRockScissorsGame.
         */
        public PaperRockScissorsGame build() {
            return new PaperRockScissorsGame(roundManager, gameInfoWriter, inputHandler);
        }
    }
}