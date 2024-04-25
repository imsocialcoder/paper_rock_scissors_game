package com.imc.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void getNameShouldReturnCorrectName() {
        String name = "Test Player";
        Player player = new PlayerImpl(name, 0);

        assertEquals(name, player.getName());
    }

    @Test
    void getScoreShouldReturnInitialScore() {
        int initialScore = 10;
        Player player = new PlayerImpl("Test Player", initialScore);

        assertEquals(initialScore, player.getScore());
    }

    @Test
    void increaseScoreShouldIncrementScoreByHundred() {
        Player player = new PlayerImpl("Test Player", 0);

        player.increaseScore();

        assertEquals(100, player.getScore());
    }

    // Implementation of Player for testing purposes
    private static class PlayerImpl extends Player {
        public PlayerImpl(String name, int score) {
            super(name, score);
        }

        @Override
        public void increaseScore() {
            score += 100;
        }
    }
}
