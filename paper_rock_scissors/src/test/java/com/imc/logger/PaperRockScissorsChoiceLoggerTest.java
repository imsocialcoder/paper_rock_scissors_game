package com.imc.logger;

import com.imc.choice.model.Choice;
import com.imc.player.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.mockito.Mockito.verify;

class PaperRockScissorsChoiceLoggerTest {

    @Test
    void logChoiceShouldLogCorrectly() {
        Player player = Mockito.mock(Player.class);
        Logger logger = Mockito.mock(Logger.class);
        PaperRockScissorsChoiceLogger choiceLogger = new PaperRockScissorsChoiceLogger(player, logger);
        Choice choice = Choice.PAPER;

        Mockito.when(player.getName()).thenReturn("Test Player");

        choiceLogger.logChoice(choice);

        verify(logger).info("{}: {}", player.getName(), choice);
    }
}
