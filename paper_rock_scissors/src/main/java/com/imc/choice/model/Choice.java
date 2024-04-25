package com.imc.choice.model;

/**
 * An enum representing a choice of Paper in the Paper-Rock-Scissors game.
 * Paper beats Rock but loses to Scissors.
 */
public enum Choice {
    PAPER {
        /**
         * Determines whether Paper wins against the opponent's choice.
         * Paper wins against Rock.
         *
         * @param opponent The opponent's choice.
         * @return true if opponent's choice is Rock, false otherwise.
         */
        @Override
        public boolean winsAgainst(Choice opponent) {
            return opponent == ROCK;
        }

        /**
         * Returns a string representation of Paper.
         *
         * @return The string "Paper".
         */
        @Override
        public String toString() {
            return "Paper";
        }
    },
    ROCK {
        /**
         * Determines whether Rock wins against the opponent's choice.
         * Rock wins against Scissors.
         *
         * @param opponent The opponent's choice.
         * @return true if opponent's choice is Scissors, false otherwise.
         */
        @Override
        public boolean winsAgainst(Choice opponent) {
            return opponent == SCISSORS;
        }

        /**
         * Returns a string representation of Rock.
         *
         * @return The string "Rock".
         */
        @Override
        public String toString() {
            return "Rock";
        }
    },
    SCISSORS {
        /**
         * Determines whether Scissors wins against the opponent's choice.
         * Scissors wins against Paper.
         *
         * @param opponent The opponent's choice.
         * @return true if opponent's choice is Paper, false otherwise.
         */
        @Override
        public boolean winsAgainst(Choice opponent) {
            return opponent == PAPER;
        }

        /**
         * Returns a string representation of Scissors.
         *
         * @return The string "Scissors".
         */
        @Override
        public String toString() {
            return "Scissors";
        }
    };

    /**
     * Abstract method to determine if this choice wins against the opponent's choice.
     *
     * @param opponent The opponent's choice.
     * @return true if this choice wins against the opponent, false otherwise.
     */
    public abstract boolean winsAgainst(Choice opponent);
}
