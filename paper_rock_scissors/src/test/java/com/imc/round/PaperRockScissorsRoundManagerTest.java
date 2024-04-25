package com.imc.round;

import com.imc.choice.generator.ChoiceGenerator;
import com.imc.choice.model.Choice;
import com.imc.input.choice.ChoiceInputHandler;
import com.imc.logger.ChoiceLogger;
import com.imc.score.updater.ScoreUpdater;
import com.imc.score.writer.ScoreWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class PaperRockScissorsRoundManagerTest {
    private ChoiceGenerator choiceGenerator;
    private ChoiceInputHandler choiceInputHandler;
    private ScoreUpdater scoreUpdater;
    private ScoreWriter scoreWriter;
    private ChoiceLogger choiceLogger;

    private PaperRockScissorsRoundManager roundManager;

    @BeforeEach
    void setUp() {
        choiceGenerator = Mockito.mock(ChoiceGenerator.class);
        choiceInputHandler = Mockito.mock(ChoiceInputHandler.class);
        scoreUpdater = Mockito.mock(ScoreUpdater.class);
        scoreWriter = Mockito.mock(ScoreWriter.class);
        choiceLogger = Mockito.mock(ChoiceLogger.class);

        roundManager = new PaperRockScissorsRoundManager.Builder()
                .withChoiceGenerator(choiceGenerator)
                .withChoiceInputHandler(choiceInputHandler)
                .withScoreUpdater(scoreUpdater)
                .withScoreWriter(scoreWriter)
                .withChoiceLogger(choiceLogger)
                .build();
    }

    @Test
    void playRoundsShouldPlaySpecifiedNumberOfRounds() {
        Choice computerChoice = Choice.PAPER;
        Mockito.when(choiceGenerator.makeChoice()).thenReturn(computerChoice);

        Choice userChoice = Choice.SCISSORS;
        Mockito.when(choiceInputHandler.getUserChoice()).thenReturn(userChoice);

        int numberOfRounds = 3;

        roundManager.playRounds(numberOfRounds);

        verify(choiceGenerator, times(numberOfRounds)).makeChoice();
        verify(choiceInputHandler, times(numberOfRounds)).getUserChoice();
        verify(scoreUpdater, times(numberOfRounds)).updateScore(userChoice, computerChoice);
        verify(scoreWriter, times(numberOfRounds)).writeScore();
        verify(choiceLogger, times(numberOfRounds)).logChoice(computerChoice);
    }
}
