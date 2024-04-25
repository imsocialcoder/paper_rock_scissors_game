package com.imc.game;

import com.imc.gameinfo.GameInfoWriter;
import com.imc.input.round.RoundInputHandler;
import com.imc.round.RoundManager;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaperRockScissorsGameTest {
    private final RoundManager roundManager = mock(RoundManager.class);
    private final GameInfoWriter gameInfoWriter = mock(GameInfoWriter.class);
    private final RoundInputHandler inputHandler = mock(RoundInputHandler.class);

    @Test
    void playGameShouldInvokeMethods() {
        PaperRockScissorsGame game = new PaperRockScissorsGame.PaperRockScissorsGameBuilder()
                .withRoundManager(roundManager)
                .withGameInfoWriter(gameInfoWriter)
                .withRoundInputHandler(inputHandler)
                .build();

        game.playGame();

        verify(gameInfoWriter, times(1)).writeGameInfo();
        verify(roundManager, times(1)).playRounds(anyInt());
        verify(inputHandler, times(1)).getNumberOfRounds();
    }
}
