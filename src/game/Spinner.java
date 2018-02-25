package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 * This is a obstacle in which the player avoids 
 */
public class Spinner extends DynamicBody{
    
    /**
     *
     * @param w is the world in which the body exist
     */
    public Spinner(World w) {
        super(w);
        
        //This is a rotating dynamic platform 
        Shape rp = new BoxShape(.1f, 2.0f);
                
        for (int i=0; i<5; i++){
        
         DynamicBody p1 = new DynamicBody(w);
                p1.setPosition(new Vec2(-10.0f + i*7.5f, -1.5f + i));
                //p1.setLinearVelocity(new Vec2(-25f, -25f));
                p1.setAngularVelocity(-3.7f);
                //p.applyTorque(1);
                SolidFixture fixture = new SolidFixture(p1, rp, 35f);
                fixture.setFriction(0);
                fixture.setRestitution(1);
                fixture.setDensity(2);
                p1.setGravityScale(0);
        }
    
    }
}
