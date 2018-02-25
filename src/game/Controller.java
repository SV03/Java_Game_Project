package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
/**
 * This declares the velocity of the jumping speed
 */
    private static float JUMPING_SPEED = 12;
/**
 * This declares the velocity of the walking speed
 */
    private static float WALKING_SPEED = 4;
    
/**
 * This declares the SoundClip of the jumpSound 
 */
    private static SoundClip jumpSound;
/**
 * This declares the a body of type Walker
 */
    private Walker body;
    private static final BodyImage image =
        new BodyImage("data/large.gif", 3f);
    private static final BodyImage imageR =
        new BodyImage("data/rotatelarge.gif", 3f);
    
    /**
     *
     * @param body
     */
    public Controller(Walker body) {
        this.body = body;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE || code == KeyEvent.VK_W ||
                code == KeyEvent.VK_UP) { // spacebar, w or up arrow key = jump
                jumpSound.play();
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                jumpSound.play();
            }
        } else if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // a or left arrow key = walk left
            body.removeAllImages();
            body.addImage(image);
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // d or right arrow key = walk right
            body.removeAllImages();
            body.addImage(imageR);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    /**
     *
     * @param body
     */
    public void setBody(Walker body) {
        this.body = body;
    }

    /**
     *
     * @return this returns the jumping speed of the player
     */
    public static float getJUMPING_SPEED() {
        return JUMPING_SPEED;
    }

    /**
     * This sets a 
     */
    public static void setJUMPING_SPEED() {
        Controller.JUMPING_SPEED = JUMPING_SPEED;
    }

    /**
     *
     * @return the walking speed of the player
     */
    public static float getWALKING_SPEED() {
        return WALKING_SPEED;
    }

    /**
     *
     */
    public static void setWALKING_SPEED() {
        Controller.WALKING_SPEED = WALKING_SPEED;
    }
    
    static {
        try {

           jumpSound = new SoundClip("data/jump.wav");
           //System.out.println("Loading bone sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        
                
        }
    }
