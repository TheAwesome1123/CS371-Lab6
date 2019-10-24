package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int playerToMove;
    private int player0Score;
    private int player1Score;
    private int runTotal;
    private int diceValue;

    public PigGameState() {
        player0Score = 0;
        player1Score = 0;
        runTotal = 0;
        playerToMove= 0;
        diceValue = 1;
    }

    public PigGameState(PigGameState pgs) {
        this.playerToMove = pgs.playerToMove;
        this.player0Score = pgs.player0Score;
        this.player1Score = pgs.player1Score;
        this.runTotal = pgs.runTotal;
        this.diceValue = pgs.diceValue;
    }

    int getPlayerToMove() {
       return this.playerToMove;
    }

    int getPlayer0Score() {
        return this.player0Score;
    }

    int getPlayer1Score() {
        return this.player1Score;
    }

    int getRunTotal() {
        return this.runTotal;
    }

    int getDiceValue() {
        return this.diceValue;
    }



    void setPlayerToMove(int move) {
        this.playerToMove = move;
    }

    void setPlayer0Score(int score0) {
        this.player0Score = score0;
    }

    void setPlayer1Score(int score1) {
        this.player1Score = score1;
    }

    void setRunTotal(int total) {
        this.runTotal = total;
    }

    void setDiceValue(int value) {
        this.diceValue = value;
    }

}
