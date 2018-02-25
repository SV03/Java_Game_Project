/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author Sarath
 */
/**
 * This is a hearts pick up which the player collects to increase there lives 
 */
public class Hearts extends Walker {
    private static final Shape heartShape = new PolygonShape(-0.311f,0.045f, -0.005f,
            -0.255f, 0.293f,0.054f, 0.29f,0.21f, 0.194f,0.303f, -0.226f,0.295f, -0.306f,0.215f);
            //new CircleShape(radius);
    private static final BodyImage heartImage =
        new BodyImage("data/heart.png", 1);
    
    /**
     *
     * @param w is the world in which the body exist
     */
    public Hearts(World w) {
        super(w, heartShape);
        addImage(heartImage);

    }
}
