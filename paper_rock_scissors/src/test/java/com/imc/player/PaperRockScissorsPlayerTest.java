package com.imc.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperRockScissorsPlayerTest {

    @Test
    void increaseScoreShouldIncrementScoreByOne() {
        PaperRockScissorsPlayer player = new PaperRockScissorsPlayer("Player 1");

        player.increaseScore();

        assertEquals(1, player.getScore());
    }
}
