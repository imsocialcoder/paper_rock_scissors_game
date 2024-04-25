package com.imc;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PaperRockScissorsTest {

    @Test
    void testMainMethod() {

        String simulatedInput = "1\nrock";

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> PaperRockScissors.main(new String[]{}));
    }
}
