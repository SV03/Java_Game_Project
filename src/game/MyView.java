/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import static game.Game.level;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Sarath
 */
/**
 * This added on screen writing to the game 
 */
public class MyView extends UserView {
    private Player player;
    private Image background1, background2, background3,background4;
    private Game game;
    
    /**
     *
     * @param game
     * @param world
     * @param width
     * @param height
     */
    public MyView(Game game, World world, int width, int height) {
        super(world, width, height);
        background1 = new ImageIcon("data/background1.jpg").getImage();
        background2 = new ImageIcon("data/background2.png").getImage();
        background3 = new ImageIcon("data/background4.jpg").getImage();
        background4 = new ImageIcon("data/background4.png").getImage();
        
        this.game =game;
        this.background1=background1.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        this.background2=background2.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        this.background3=background3.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        
    }
     
    /**
     *This is where the background of the world is painted
     * @param g description of the Graphic2D
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        if(level == 1){
            g.drawImage(background1, 0,0, this);
            g.setColor(Color.white);
            g.fillRoundRect(400, 30, 10, 10, WIDTH, HEIGHT);
        } else if (level == 2){
            g.drawImage(background2, 0,0, this);
            g.setColor(Color.white);
            g.fillRoundRect(400, 30, 10, 10, WIDTH, HEIGHT);
            g.fillRoundRect(411, 30, 10, 10, WIDTH, HEIGHT);
        } else if (level == 3){
            g.drawImage(background3, 0,0, this);
            g.setColor(Color.white);
            g.fillRoundRect(400, 30, 10, 10, WIDTH, HEIGHT);
            g.fillRoundRect(411, 30, 10, 10, WIDTH, HEIGHT);
            g.fillRoundRect(422, 30, 10, 10, WIDTH, HEIGHT);
        }else if (level == 4){
            g.drawImage(background4, 0,0, this);
            g.setColor(Color.white);
            g.fillRoundRect(400, 30, 10, 10, WIDTH, HEIGHT);
            g.fillRoundRect(411, 30, 10, 10, WIDTH, HEIGHT);
            g.fillRoundRect(422, 30, 10, 10, WIDTH, HEIGHT);
            g.fillRoundRect(433, 30, 10, 10, WIDTH, HEIGHT);
        }
       
        
    }

    /**
     *This is where the foreground of the world is painted
     * @param g description of the Graphic2D
     */
    @Override 
    protected void paintForeground(Graphics2D g){
        
        g.drawRect(9, 5, 75, 50);
        g.setFont(new Font("TimesRoman", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString("Score " + game.getPlayer().getScore(), 10, 20);
        g.drawString("Lives " + game.getPlayer().getNumberOfLives(), 10, 40);
        g.setColor(Color.white);
        g.drawString("Level "+ game.getLevelCount(), 400, 20);
    }
}

