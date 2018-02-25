/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Sarath
 */
/**
 * This is a coin pick up which the player collects to increase there score to move on to the next level
 */
public class Coin extends DynamicBody {
    private static final float radius = 0.4f;
    private static final Shape coinShape = new CircleShape(radius);
    private static final BodyImage coinImage =
        new BodyImage("data/coin.gif", 3.2f*radius);
/**
 * Declares SoundClip class
 */
    private static SoundClip coinSound;
    
    /**
     *
     * @param w is the world where the the body exist
     */
    public Coin(World w) {
        super(w, coinShape);
        addImage(coinImage);

    }
    static {
        try {

           coinSound = new SoundClip("data/coin.wav");
           //System.out.println("Loading bone sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        
                
} 

    /**
     * If character collides with the body, character is destroyed
     */
    @Override
    public void destroy(){
        coinSound.play();
        super.destroy();
    }
}
