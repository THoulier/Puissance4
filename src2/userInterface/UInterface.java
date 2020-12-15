package userInterface;

import game.Player;

public interface UInterface {
    int interfaceRounds();
    int getUserEntry();
    boolean getExit();
    Player[] interfacePlayer();
    int [] interfaceGridSize();
}
