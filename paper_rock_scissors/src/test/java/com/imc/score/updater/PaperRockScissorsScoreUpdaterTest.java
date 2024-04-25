package com.imc.score.updater;

import com.imc.choice.model.Choice;
import com.imc.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.mockito.Mockito.verify;

class PaperRockScissorsScoreUpdaterTest {
    private final Player user = Mockito.mock(Player.class);
    private final Player computer = Mockito.mock(Player.class);
    private final Logger logger = Mockito.mock(Logger.class);

    private ScoreUpdater scoreUpdater;
    @BeforeEach
    void setUp(){
        Mockito.when(user.getName()).thenReturn("Mock User");
        Mockito.when(computer.getName()).thenReturn("Mock Computer");
        scoreUpdater = new PaperRockScissorsScoreUpdater(user, computer, logger);
    }

    @Test
    void updateScoreShouldIncreaseUserScoreIfUserWins() {
        Choice userChoice = Choice.PAPER;
        Choice computerChoice = Choice.ROCK;

        scoreUpdater.updateScore(userChoice, computerChoice);

        verify(user).increaseScore();
        logger.info("{} wins!", "Mock User");
    }

    @Test
    void updateScoreShouldIncreaseComputerScoreIfComputerWins() {
        Choice userChoice = Choice.ROCK;
        Choice computerChoice = Choice.PAPER;

        scoreUpdater.updateScore(userChoice, computerChoice);

        verify(computer).increaseScore();
        logger.info("{} wins!", "Mock Computer");
    }

    @Test
    void updateScoreShouldNotIncreaseAnyScoreIfDraw() {
        Choice userChoice = Choice.ROCK;
        Choice computerChoice = Choice.ROCK;

        scoreUpdater.updateScore(userChoice, computerChoice);

        verify(user, Mockito.never()).increaseScore();
        verify(computer, Mockito.never()).increaseScore();
        verify(logger).info("Draw!");
    }
}
