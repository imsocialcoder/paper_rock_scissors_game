package com.imc;

import com.imc.choice.generator.ChoiceGenerator;
import com.imc.choice.generator.RandomChoiceGenerator;
import com.imc.game.PaperRockScissorsGame;
import com.imc.gameinfo.GameInfoWriter;
import com.imc.gameinfo.PaperRockScissorsInfoWriter;
import com.imc.input.choice.ChoiceInputHandler;
import com.imc.input.choice.ConsoleChoiceInputHandler;
import com.imc.input.round.ConsoleRoundInputHandler;
import com.imc.input.round.RoundInputHandler;
import com.imc.logger.ChoiceLogger;
import com.imc.logger.PaperRockScissorsChoiceLogger;
import com.imc.player.PaperRockScissorsPlayer;
import com.imc.player.Player;
import com.imc.round.PaperRockScissorsRoundManager;
import com.imc.round.RoundManager;
import com.imc.score.updater.PaperRockScissorsScoreUpdater;
import com.imc.score.updater.ScoreUpdater;
import com.imc.score.writer.PaperRockScissorsScoreWriter;
import com.imc.score.writer.ScoreWriter;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class PaperRockScissors {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Player user = new PaperRockScissorsPlayer("Player");
        final Player computer = new PaperRockScissorsPlayer("Computer");
        final ChoiceLogger choiceLogger = new PaperRockScissorsChoiceLogger(computer, LoggerFactory.getLogger(PaperRockScissorsChoiceLogger.class));
        final ChoiceGenerator choiceGenerator = new RandomChoiceGenerator();
        final ChoiceInputHandler choiceInputHandler = new ConsoleChoiceInputHandler(scanner, LoggerFactory.getLogger(ConsoleChoiceInputHandler.class));
        final RoundInputHandler roundInputHandler = new ConsoleRoundInputHandler(scanner, LoggerFactory.getLogger(ConsoleRoundInputHandler.class));
        final ScoreUpdater scoreUpdater = new PaperRockScissorsScoreUpdater(user, computer, LoggerFactory.getLogger(PaperRockScissorsScoreUpdater.class));
        final ScoreWriter scoreWriter = new PaperRockScissorsScoreWriter(user, computer, LoggerFactory.getLogger(PaperRockScissorsScoreWriter.class));
        final GameInfoWriter gameInfoWriter = new PaperRockScissorsInfoWriter.Builder()
                .withUser(user)
                .withComputer(computer)
                .withScoreWriter(scoreWriter)
                .withLogger(LoggerFactory.getLogger(PaperRockScissorsInfoWriter.class))
                .build();

        final RoundManager roundManager = new PaperRockScissorsRoundManager.Builder()
                .withChoiceGenerator(choiceGenerator)
                .withChoiceInputHandler(choiceInputHandler)
                .withScoreUpdater(scoreUpdater)
                .withScoreWriter(scoreWriter)
                .withChoiceLogger(choiceLogger)
                .build();

        new PaperRockScissorsGame.PaperRockScissorsGameBuilder()
                .withGameInfoWriter(gameInfoWriter)
                .withRoundInputHandler(roundInputHandler)
                .withRoundManager(roundManager)
                .build()
                .playGame();
    }
}