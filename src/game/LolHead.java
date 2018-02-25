/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author Sarath
 */
/**
 * This is the enemy class which is know a lolHeads which decreases the players lives on collisions
 */
public class LolHead extends DynamicBody{
   // private static final float radius = 0.5f;
    private static final Shape lolheadShape = new PolygonShape(-0.51f,1.43f, 0.21f,
            1.46f, 1.05f,1.13f, 1.09f,-1.04f, 0.27f,-1.46f, -0.65f,-1.2f, -1.07f,-0.22f, -1.11f,0.82f);
            //new CircleShape(radius);
    private static final BodyImage lolheadImage =
        new BodyImage("data/lolhead.png", 3);
    SolidFixture lolheadFixture = new SolidFixture(this, lolheadShape, 1);
    
    public LolHead(World w) {
        super(w, lolheadShape);
        addImage(lolheadImage);
        lolheadFixture.setRestitution(0.5f);
        this.setGravityScale(0.5f );

    }
}
