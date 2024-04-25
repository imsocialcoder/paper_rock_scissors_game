package com.imc.choice.generator;

import com.imc.choice.model.Choice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomChoiceGeneratorTest {

    @Test
    void shouldGenerateValidChoice_WhenMakeChoiceCalled() {
        RandomChoiceGenerator choiceGenerator = new RandomChoiceGenerator();
        Choice choice = choiceGenerator.makeChoice();

        assertTrue(choice == Choice.PAPER || choice == Choice.ROCK || choice == Choice.SCISSORS);
    }
}
