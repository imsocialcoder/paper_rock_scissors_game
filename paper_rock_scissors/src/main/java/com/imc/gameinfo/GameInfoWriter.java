package com.imc.gameinfo;

/**
 * An interface which defines the contract for classes responsible for writing game information.
 * Implementing classes should provide functionality to write information about a specific game instance.
 */
public interface GameInfoWriter {
    /**
     * Writes information about the game.
     **/
    void writeGameInfo();
}
