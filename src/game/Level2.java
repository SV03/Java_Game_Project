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
 * Creates the second level of the game
 */
public class Level2 extends GameLevel {
    
    private static final int leave = 4;
    private LolHead lolhead;
    private Hearts heart;
    private Spike spike;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // build ground
        Shape ground1 = new BoxShape(12.5f, 0.2f);
        Body ground = new StaticBody(this, ground1);
        ground.setPosition(new Vec2(-2, -40f));
        
        // build walls
        Shape wallShape = new BoxShape(0.2f, 10);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-12.5f, -3));
        
        Body leftWall2 = new StaticBody(this,wallShape);
        leftWall2.setPosition(new Vec2(-12.5f, -25));
        
        Body rightWall = new StaticBody(this, new BoxShape(0.2f,0.5f));
        rightWall.setPosition(new Vec2(12.5f, -12));
        
        //spikes
        for (int i=0; i<5; i++){
            spike = new Spike(this);
            spike.setPosition(new Vec2(-12,-10-i*2.8f ));
            spike.setAngleDegrees(-90);
            spike.addCollisionListener(new Pickup(getPlayer(),game));
        }
        //build platform
        for(int i=0; i<=3; i++){
            Shape platform1 = new BoxShape(2.7f,0.2f);
            Body platform = new StaticBody(this, platform1);
            platform.setPosition(new Vec2(0+i*15,0+i*2));
            platform.setAngleDegrees(30);
        }
        
        Shape platform2 = new BoxShape(8f,0.2f);
        Body platform = new StaticBody(this, platform2);
        platform.setPosition(new Vec2(6,-10));
        
        //make lolhead
        for (int i =0; i<20; i++){
            Body lolHead = new LolHead(this);
            lolHead.setPosition(new Vec2(0+i, -5+i));
            lolHead.addCollisionListener(new Pickup(getPlayer(),game));
            
            
        }

        
        //Gems and Coins
        for (int i = 0; i < 11; i++) {
        if (i%3 == 0){
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(i*2-7, -15));
            gem.addCollisionListener(new Pickup(getPlayer(),game));
        }else {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*1.9f-7, -15));
            coin.addCollisionListener(new Pickup(getPlayer(),game)); }
        }
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(-2,-15));
            gem.addCollisionListener(new Pickup(getPlayer(),game)); 
            
       
    }
    /*
     * This represent the start position of the player character at the start of the level
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -35);
    }
    
    /*
     * This represent the start position of the portal at the start of the level
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(-15.4f, -9.6f);
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

