/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 * Creates the first level of the game
 */
public class Level1 extends GameLevel {
    
    private static final int leave = 2;
    private Spike spike;
    private Bomber bomber, bomber2;
    private EnergyDrink edrink;
    
    /**
     * Populate the world.
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        

        // build ground
        Shape ground1 = new BoxShape(12.5f, 0.2f);
        Body ground = new StaticBody(this, ground1);
        ground.setPosition(new Vec2(0, -12.3f));
         
        
        // build walls
        Shape wallShape = new BoxShape(0.2f, 9);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-12.5f, -3.5f));
        Body rightWall = new StaticBody(this, new BoxShape(0.2f,0.5f));
        rightWall.setPosition(new Vec2(12.5f, -12));
        
        //build platform
        for(int i=0; i<=3; i++){
            Shape platform1 = new BoxShape(2.7f,0.2f);
            Body platform = new StaticBody(this, platform1);
            platform.setPosition(new Vec2(0+i*13,0+i*2));
        }
        
        Shape platform2 = new BoxShape(0.7f,0.2f);
        Body platform = new StaticBody(this, platform2);
        platform.setPosition(new Vec2(9,-1));
        
        Shape platform3 = new BoxShape(2f,0.2f);
        Body platform1 = new StaticBody(this, platform3);
        platform1.setPosition(new Vec2(-10,-5));
        
        
        //make enemy characters
        bomber = new Bomber(this);
        bomber.setPosition(new Vec2(0.5f,2));
        bomber.addCollisionListener(new Pickup(getPlayer(), game));
        
        bomber2 = new Bomber(this);
        bomber2.setPosition(new Vec2(1f,-5));
        bomber2.addCollisionListener(new Pickup(getPlayer(), game));
        
        //spikes on floor and underneath platform
        for (int i=0; i<5; i++){
            spike = new Spike(this);
            spike.setPosition(new Vec2(0-i,-11.5f));
            spike.addCollisionListener(new Pickup(getPlayer(), game));

            spike = new Spike(this);
            spike.setPosition(new Vec2(2-i,-0.5f));
            spike.setAngleDegrees(180);
            spike.addCollisionListener(new Pickup(getPlayer(), game));
        }
        

        for (int i = 0; i < 11; i++) {
        if (i%3 == 0){
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(i*2-7, -9));
            gem.addCollisionListener(new Pickup(getPlayer(), game));
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
        return new Vec2(2, -10);
    }
    /*
     * This represent the start position of the portal at the start of the level
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(45f, 10f);
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
