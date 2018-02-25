/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Sarath
 */
/**
 * This is a gem pick up which the player collects to increase there score to move on to the next level
 */
public class Gem extends Walker {
    
    private static final float radius = 0.5f;
    private static final Shape gemShape = new PolygonShape(-0.192f,0.476f, 0.137f,0.481f, 0.385f,0.13f, 0.387f,-0.288f, 0.168f,-0.481f, -0.209f,-0.483f, -0.38f,-0.262f, -0.38f,0.168f);
            //new CircleShape(radius);
    private static final BodyImage gemImage =
        new BodyImage("data/Gem.png", 2*radius);
    private static SoundClip gemSound;
    
    public Gem(World w) {
        super(w, gemShape);
        addImage(gemImage);

    }
    static {
        try {

           gemSound = new SoundClip("data/gem.wav");
           //System.out.println("Loading bone sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }
        
                
} 
        @Override
    public void destroy(){
        gemSound.play();
        super.destroy();
    }
}