package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 *Creates the Game World
 */
/*
Features Implented in the game
1) We have a main character which the player which can pick up items and can be 
controlled by using ethier the following command;
JUMP; Spacebar or 'W' or 'Up arrow key'
LEFT; 'A' or 'Left arrow key'
RIGHT; 'D' or 'Right arrow key'

2) There is an enemy which will reset your character to there orginal start 
position and lives however the users score will be reset to zero;

3) There are collectables such as coins and gems which will increase your score 
throughout the game

4) There are obstacles such as spikes which will decrement the number of lives of
the player

5) There is also a spinning platform, which is meant to obstruct the player when 
jumping from different platforms or to assist them in the game (HINT: it can also 
be ridden onto the spikes to obtain the gems and coins located above them)
*/
// Game World 
public class GameWorld extends World {
    private final Player player;
    private Spike spike;
    private final Bomber bomber, bomber2;
    
    public GameWorld() {
        super();
        
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
            platform.setPosition(new Vec2(0+i*15,0+i*2));
        }
        
        Shape platform2 = new BoxShape(0.7f,0.2f);
        Body platform = new StaticBody(this, platform2);
        platform.setPosition(new Vec2(9,-1));
        

        // make a character
        player = new Player(this);
        player.setPosition(new Vec2(8, -7f));
        
        //make enemy characters
        bomber = new Bomber(this);
        bomber.setPosition(new Vec2(0.5f,2));
        //bomber.addCollisionListener(new Pickup(player));
        
        bomber2 = new Bomber(this);
        bomber2.setPosition(new Vec2(1f,-5));
        //bomber2.addCollisionListener(new Pickup(player));
        
        
        //spikes on floor and underneath platform
        for (int i=0; i<5; i++){
            spike = new Spike(this);
            spike.setPosition(new Vec2(0-i,-11.5f));
            //spike.addCollisionListener(new Pickup(player));

            spike = new Spike(this);
            spike.setPosition(new Vec2(2-i,-0.5f));
            spike.setAngleDegrees(180);
            //spike.addCollisionListener(new Pickup(player));
        }
        
        //make spinner
        DynamicBody spinner = new Spinner (this);
        
        // Coins and Gems
        for (int i = 0; i < 11; i++) {
        if (i%3 == 0){
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(i*2-7, -9));
            //gem.addCollisionListener(new Pickup(player));
        }else {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*1.9f-7, -9));
            //coin.addCollisionListener(new Pickup(player)); }
        }
            Body gem = new Gem(this);
            gem.setPosition(new Vec2(-2,2));
            //gem.addCollisionListener(new Pickup(player)); 
        
    }
    
        /*public Player getPlayer() {
        return player;
        }*/
}}
