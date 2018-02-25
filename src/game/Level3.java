/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 * Creates the third level of the game
 */
public class Level3 extends GameLevel {
    
    private static final int leave = 4;
    private Ghost ghost;
    private Hearts heart;
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // build ground
        for (int i=0; i < 15; i++){
        Shape ground1 = new BoxShape(0.5f, 0.2f);
        Body ground = new StaticBody(this, ground1);
        ground.setPosition(new Vec2(-16+i*3, -12));
        }
        
        // build walls
        Shape wallShape = new BoxShape(0.2f, 10);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setAngleDegrees(45);
        leftWall.setPosition(new Vec2(-12.5f, -3.5f));
        Body rightWall = new StaticBody(this, new BoxShape(0.2f,17));
        rightWall.setPosition(new Vec2(12.5f, -3.5f));
        
        //build platform
        for(int i=0; i<=3; i++){
            Shape platform1 = new BoxShape(2.7f,0.2f);
            Body platform = new StaticBody(this, platform1);
            platform.setPosition(new Vec2(0+i*15,0+i*2));
        }
        
        Shape platform2 = new BoxShape(0.7f,0.2f);
        Body platform = new StaticBody(this, platform2);
        platform.setPosition(new Vec2(9,-1));
        
        Shape platform3 = new BoxShape(30,0.2f);
        Body platform1 = new StaticBody(this, platform3);
        platform1.setPosition(new Vec2(-16,-25));
        
        ghost = new Ghost(this);
        ghost.setPosition(new Vec2(0,0));
        ghost.addCollisionListener(new Pickup(getPlayer(),game));
        addStepListener(ghost);
        
        for (int i = 0; i < 11; i++) {
            ghost = new Ghost(this);
            ghost.setPosition(new Vec2(i*2-7, -3*i));
            ghost.addCollisionListener(new Pickup(getPlayer(),game));
            addStepListener(ghost);
            
        }
        
        //Madke hearts
        for (int i = 0; i <4; i++){
            heart = new Hearts(this);
            heart.setPosition(new Vec2(i*2-4,-9));
            heart.addCollisionListener(new Pickup(getPlayer(),game));
        
        }

        for (int i = 0; i < 11; i++) {
        if (i%3 == 0){
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(i*2-7, -9));
            gem.addCollisionListener(new Pickup(getPlayer(),game));
        }else {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*1.9f-7, -9));
            coin.addCollisionListener(new Pickup(getPlayer(),game)); }
        }
        
        
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(-2,2));
            gem.addCollisionListener(new Pickup(getPlayer(),game)); 
    }
    
    /*
     * This represent the start position of the player character at the start of the level
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }
    
    /*
     * This represent the start position of the portal at the start of the level
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(10f, -20.6f);
    }
    /*
     * This represent the that the level has been completed and confirmed that the player has reached 
        the required score to move on
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().scoreCount() >= leave;
    }
}
