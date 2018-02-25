package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Sarath
 */
/**
 * This is the portal listener which is used when the player makes a collision with the portal 
 */
public class PortalListener implements CollisionListener{
    private Game game;
    private static SoundClip nextlevel;
    
    /**
     *
     * @param game is being initialised 
     */
    public PortalListener(Game game) {
        this.game = game;
    }
    
    /**
     *
     * @param e represents the collision event of the player with the portal to the next level
     */
    @Override
    public void collide(CollisionEvent e) {
        Player player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
            nextlevel.play();
        }
    }
    static {
        try {

           nextlevel = new SoundClip("data/nextlevel.wav");
           //System.out.println("Loading bone sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        
                
}
   
}
