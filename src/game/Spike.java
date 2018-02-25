/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarath
 */
/**
 * This is a obstacle for the player to avoid
 */
package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Sarath
 */
public class Spike extends StaticBody { 

    private static final Shape spike = new PolygonShape(0.0f,0.49f, 0.57f,-0.5f,-0.57f,-0.49f);
    SolidFixture PlayerFixture = new SolidFixture(this, spike, 1);
    private static SoundClip spikeSound;
    private static final BodyImage image =
        new BodyImage("data/spike.png");
    
    /**
     *
     * @param w is the world in which the body exist
     */
    public Spike(World w) {
        super(w, spike);
        addImage(image);

    }
    static {
        try {

           spikeSound = new SoundClip("data/ow.wav");
           //System.out.println("Loading bone sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        
                
} 

    /**
     * When the spike is destroyed in the game the spikeSound is played
     */
    @Override
    public void destroy(){
        spikeSound.play();
        super.destroy();
    }
    
}