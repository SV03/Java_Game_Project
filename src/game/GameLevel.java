/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Sarath
 */
/**
 * The Game level is made
 */
public abstract class GameLevel extends World {
    private Player player;
    
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        player = new Player(this);
        player.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit portal. */
    public abstract Vec2 portalPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}
