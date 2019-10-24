package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState) {
            if(playerNum == ((PigGameState) info).getPlayerToMove()) {
                Random choose = new Random();
                PigHoldAction pha = new PigHoldAction(this);
                PigRollAction pra = new PigRollAction(this);
                int chosen = choose.nextInt(2);

                if (chosen == 0) {
                    game.sendAction(pha);
                }
                else {
                    game.sendAction(pra);
                }
            }
        }
        else {
            return;
        }
    }//receiveInfo
}
