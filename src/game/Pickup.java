package game;

import city.cs.engine.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbox2d.common.Vec2;

// Collision listener allow player to collect items 

/**
 *
 * @author Sarath
 */
/**
 * The class handles all collisions types of pick up and obstacles
 */
public class Pickup implements CollisionListener {

    private Player player;
    private Bomber bomber, bomber2;
    private EnergyDrink edrink;
    private Game game;

    /**
     *
     * @param player this initialises the player and game 
     * @param game
     */
    public Pickup(Player player, Game game) {
        this.player = player;
         this.game = game;
    }

    /**
     *
     * @param e represents the collision event of the player body class and other bodies in the world 
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == player) {

            if (e.getReportingBody() instanceof Gem) {
                /*When a Gem is collected the scoreCount will increase*/
                player.incrementScoreCount();
                e.getReportingBody().destroy();

            } else if (e.getReportingBody() instanceof Coin) {
                /*When a coin is collect the scoreCount will increase*/
                player.incrementScoreCount();
                e.getReportingBody().destroy();

            } else if (e.getReportingBody() instanceof Spike) {
                /*When contact is made with the spikes the number of 
                lives decrease*/
                player.decreamentNumberOfLives();
                e.getReportingBody().destroy();
                if (player.getNumberOfLives() == 0) {
                    try {
                        //System.out.println(game);
                        game.writeScore();
                        player.destroy();
                        System.out.println("Game Over, better luck next time");
                    } catch (IOException ex) {
                        Logger.getLogger(Pickup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            } else if (e.getReportingBody() instanceof Hearts) {
                    /*When contact is made number of lives increases by one*/
                    player.increamentNumberOfLives();
                    e.getReportingBody().destroy();

                } else if (e.getReportingBody() instanceof Ghost) {
                    player.resetGame();
                    e.getReportingBody().destroy();

                } else if (e.getReportingBody() instanceof Virus) {
                    //player.killGame();
                    e.getReportingBody().destroy();
                    

                }else if (e.getReportingBody() instanceof Bomber) {
                /*When contact is made with the bomber charater player lives and 
                score are reset and they must continue from where they left of*/
                
                player.resetNumberOfLives();
                player.resetScore();
                e.getReportingBody().destroy();

            } else if (e.getReportingBody() instanceof LolHead) {
                /* When contact is made with the LolHeads the player loses lives*/
                
                player.decreamentNumberOfLives();
                e.getReportingBody().destroy();
                if (player.getNumberOfLives() == 0) {
                    try {
                        game.writeScore();
                        player.destroy();
                        System.out.println("Game Over, better luck next time");
                    } catch (IOException ex) {
                        Logger.getLogger(Pickup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    

                } 

            }

        }
    }
}
