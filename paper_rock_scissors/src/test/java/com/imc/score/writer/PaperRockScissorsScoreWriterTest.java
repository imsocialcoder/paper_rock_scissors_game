package com.imc.score.writer;

import com.imc.player.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.mockito.Mockito.verify;

class PaperRockScissorsScoreWriterTest {

    @Test
    void writeScoreShouldLogCorrectly() {
        Player user = Mockito.mock(Player.class);
        Player computer = Mockito.mock(Player.class);
        Mockito.when(user.getName()).thenReturn("Mock User");
        Mockito.when(user.getScore()).thenReturn(3);
        Mockito.when(computer.getName()).thenReturn("Mock PC");
        Mockito.when(computer.getScore()).thenReturn(5);
        Logger logger = Mockito.mock(Logger.class);

        PaperRockScissorsScoreWriter scoreWriter = new PaperRockScissorsScoreWriter(user, computer, logger);

        scoreWriter.writeScore();

        String expectedScoreInfo = """

                Score
                -------------
                Mock User : 3
                Mock PC   : 5
                -------------
                """;
        verify(logger).info(expectedScoreInfo);
    }
}
