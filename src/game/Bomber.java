/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Sarath
 */
/**
 * This is the enemy class which is know a bomber
 */
public class Bomber extends Walker {
/**
 * This is the enemy class which is know a bomber
 */

    private Bomber bomber;

    private static final Shape bomberShape = new PolygonShape(-0.752f,-0.085f, 
            -0.36f,0.495f, -0.042f,0.505f, 0.568f,-0.065f, 
            0.573f,-0.702f, 0.375f,-0.857f, -0.755f,-0.857f);

    SolidFixture BomberFixture = new SolidFixture(this, bomberShape, 1);
    private static final BodyImage bomberImage
            = new BodyImage("data/bomber2.gif", 2);

    /**
     *
     * @param w description of the World 
     */
    public Bomber(World w) {
        super(w, bomberShape);
        addImage(bomberImage);
        BomberFixture.setFriction(0);
  

    }

}
