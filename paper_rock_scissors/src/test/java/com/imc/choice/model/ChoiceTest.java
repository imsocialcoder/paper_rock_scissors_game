package com.imc.choice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceTest {

    @Test
    void shouldReturnCorrectResultWhenWinsAgainstCalled() {
        assertTrue(Choice.PAPER.winsAgainst(Choice.ROCK));
        assertTrue(Choice.ROCK.winsAgainst(Choice.SCISSORS));
        assertTrue(Choice.SCISSORS.winsAgainst(Choice.PAPER));

        assertFalse(Choice.PAPER.winsAgainst(Choice.SCISSORS));
        assertFalse(Choice.ROCK.winsAgainst(Choice.PAPER));
        assertFalse(Choice.SCISSORS.winsAgainst(Choice.ROCK));

        assertFalse(Choice.PAPER.winsAgainst(Choice.PAPER));
        assertFalse(Choice.ROCK.winsAgainst(Choice.ROCK));
        assertFalse(Choice.SCISSORS.winsAgainst(Choice.SCISSORS));
    }

    @Test
    void shouldReturnStringChoicesWhenToStringCalled() {
        assertEquals("Paper", Choice.PAPER.toString());
        assertEquals("Rock", Choice.ROCK.toString());
        assertEquals("Scissors", Choice.SCISSORS.toString());
    }
}
