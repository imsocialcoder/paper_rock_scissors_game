package com.imc.gameinfo;

import com.imc.player.Player;
import com.imc.score.writer.ScoreWriter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class PaperRockScissorsInfoWriterTest {

    @Test
    void writeGameInfoShouldWriteWelcomeMessageAndDisplayScore() {
        Player user = mock(Player.class);
        Player computer = mock(Player.class);
        ScoreWriter scoreWriter = mock(ScoreWriter.class);
        Logger logger = mock(Logger.class);

        PaperRockScissorsInfoWriter infoWriter = new PaperRockScissorsInfoWriter.Builder()
                .withUser(user)
                .withComputer(computer)
                .withScoreWriter(scoreWriter)
                .withLogger(logger)
                .build();

        infoWriter.writeGameInfo();

        verify(logger).info("Welcome to Paper-Rock-ScissorsGame!");
        verify(logger).info("Players are: {} and {}", user.getName(), computer.getName());
        verify(scoreWriter, times(1)).writeScore();
    }
}
