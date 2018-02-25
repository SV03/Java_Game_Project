/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 * This is the enemy class which is know a bomber and collsions with this object will result in the game to close and end game 
 */
public class Virus extends DynamicBody{
        private Virus virus;

    private static final Shape virusShape = new PolygonShape(0.01f,0.573f, 0.53f,
            0.177f, 0.507f,-0.343f, 0.043f,-0.553f, -0.477f,-0.4f, -0.53f,0.157f);

    SolidFixture VirusFixture = new SolidFixture(this, virusShape, 1);
    private static final BodyImage virusImage
            = new BodyImage("data/virus.gif", 2);
    
    /**
     *
     * @param w is the world in which the body exist
     */
    public Virus(World w) {
        super(w, virusShape);
        addImage(virusImage);
        VirusFixture.setFriction(0);
        this.setLinearVelocity(new Vec2(2,2));
        VirusFixture.setRestitution(1f);
  
    }
}
