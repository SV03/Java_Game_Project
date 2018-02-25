/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.Walker;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 * This is the enemy class which is know a ghost and when a collision is made the game restarts
 */
public class Ghost extends Walker implements StepListener{
        private Ghost ghost;
        private int xLeft = -10;
        private int xRight = 10;
        private int direction = 3;

    private static final Shape ghostShape = new PolygonShape(-0.752f,-0.085f, 
            -0.36f,0.495f, -0.042f,0.505f, 0.568f,-0.065f, 
            0.573f,-0.702f, 0.375f,-0.857f, -0.755f,-0.857f);

    SolidFixture GhostFixture = new SolidFixture(this, ghostShape, 1);
    private static final BodyImage ghostImage
            = new BodyImage("data/raw.gif", 2);
    
    boolean Hit;

    public Ghost(World w) {
        super(w, ghostShape);
        addImage(ghostImage);
        GhostFixture.setFriction(0);
        
        Hit = true;

    }
    
    @Override
    public void preStep(StepEvent e){
        
    }
    
    @Override
    public void postStep(StepEvent e){
        if(this.getPosition().x > xRight){
            direction =-6;
        }else if (this.getPosition().x <xLeft){
            direction =8;
        }
        this.setLinearVelocity(new Vec2(direction,0));
    }
    
    public boolean getHit() {
        return Hit;
        
    }

    public void setHit() {
        Hit = true;
        System.out.println("Target was hit.");
    }
}
