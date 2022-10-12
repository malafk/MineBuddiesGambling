package lol.maltest.minebuddiesgambling.impl;

import java.util.ArrayList;
import java.util.UUID;

public class ActiveGameObject {

    public GameType gameType;
    public UUID gameOwner;
    public UUID gameVersus;

    public ActiveGameObject(GameType gameType, UUID creator) {
        this.gameType = gameType;
        this.gameOwner = creator;
    }

    public ActiveGameObject(GameType gameType, UUID creator, UUID gameVersus) {
        this.gameType = gameType;
        this.gameOwner = creator;
        this.gameVersus = gameVersus;
    }

    public void startGame() {

    }

}
