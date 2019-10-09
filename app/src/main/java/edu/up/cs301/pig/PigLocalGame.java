package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.R;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState pgs;
//    private int player;
//    private int player0Score;
//    private int player1Score;
//    private int runTotal;
//    private int diceValue;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pgs = new PigGameState();
//        this.player = pgs.getPlayerToMove();
//        this.player0Score = pgs.getPlayer0Score();
//        this.player1Score = pgs.getPlayer1Score();
//        this.runTotal = pgs.getRunTotal();
//        this.diceValue = pgs.getDiceValue();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == pgs.getPlayerToMove()) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigRollAction) {
            int run = pgs.getRunTotal();
            Random diceGen = new Random();
            pgs.setDiceValue(diceGen.nextInt(5) + 1); // maybe 6?
            int value = pgs.getDiceValue();
            if(value != 1) {
                run += value;
                pgs.setRunTotal(run);
            }
            else {
                pgs.setRunTotal(0);
                if(pgs.getPlayerToMove() == 0) {
                    pgs.setPlayerToMove(1);
                }
                else {
                    pgs.setPlayerToMove(0);
                }
            }
            return true;
        }
        else if(action instanceof PigHoldAction) {
            if(pgs.getPlayerToMove() == 0) {
                int score0 = pgs.getPlayer0Score();
                score0 += pgs.getRunTotal();
                pgs.setPlayer0Score(score0);
                pgs.setRunTotal(0);
                pgs.setPlayerToMove(1);
            }
            else if(pgs.getPlayerToMove() == 1) {
                int score1 = pgs.getPlayer1Score();
                score1 += pgs.getRunTotal();
                pgs.setPlayer1Score(score1);
                pgs.setRunTotal(0);
                pgs.setPlayerToMove(0);
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copy = pgs;
        p.sendInfo(copy);
    }//sendUpdatedSate
    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pgs.getPlayer1Score() >= 50) {
            return "Game! This game's winner is...Player 1 with a score of " + pgs.getPlayer1Score()
                    + " !";
        }
        else if(pgs.getPlayer0Score() >= 50) {
            return  "Game! This game's winner is...Player 2 with a score of " + pgs.getPlayer0Score()
                    + " !";
        }
        return null;
    }

}// class PigLocalGame
