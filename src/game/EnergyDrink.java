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
import city.cs.engine.World;

/**
 *
 * @author Sarath
 */
/**
 * This is a energy drink which the character can pick up 
 */
public class EnergyDrink extends DynamicBody{
        private static final float radius = 0.5f;
    private static final Shape edrink = new PolygonShape(-0.192f,0.476f, 0.137f,
            0.481f, 0.385f,0.13f, 0.387f,-0.288f, 0.168f,-0.481f, -0.209f,-0.483f, -0.38f,-0.262f, -0.38f,0.168f);
            //new CircleShape(radius);
    private static final BodyImage edrinkImage =
        new BodyImage("data/drink.png", 2*radius);

    public EnergyDrink(World w) {
        super(w, edrink);
        addImage(edrinkImage);
    }

    


}
