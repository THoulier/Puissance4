package userInterface;

import game.Player;

public interface UInterface {
    int interfaceRounds();
    String getUserEntry();
    boolean userExit(String str);
    int userEntry2Col(String str);
    Player[] interfacePlayer();
    int [] interfaceGridSize();
}
