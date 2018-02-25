/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author Sarath
 */
/**
 * This is a body, which has a image of a portal
 */
public class Portal extends StaticBody {   
    
    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Portal(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/portal.png", 2.8f));
    }
}
