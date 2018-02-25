 package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Sarath
 * 
 */
/**
 * The computer game
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
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;
    private SoundClip gameMusic1,gameMusic2,gameMusic3,gameMusic4;
    private HighScoreReader highScoreReader;

    /**
     *
     * @return getWorld
     */
    public GameLevel getWorld() {
        return world;
    }

    /**
     *
     * @param world
     */
    public void setWorld(GameLevel world) {
        this.world = world;
    }
    
    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    
    /**
     * 
     */
    public static int level;
    
    private Controller controller;

    /** Initialise a new Game. */
    public Game() {
        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        
        try {
           
            gameMusic1 = new SoundClip("data/music1.wav");   // Open an audio input stream
            gameMusic1.loop();  // Set it to continous playback (looping)
            
            gameMusic2 = new SoundClip("data/music2.wav");   // Open an audio input stream
            gameMusic2.stop();  // Set it to continous playback (looping)
            
            gameMusic3 = new SoundClip("data/music.wav");   // Open an audio input stream
            gameMusic3.stop();  // Set it to continous playback (looping)
            
            gameMusic4 = new SoundClip("data/music4.wav");   // Open an audio input stream
            gameMusic4.stop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
       
        // make a view
        view = new MyView(this,world, 600, 600);
        
        // draws a 1-metre grid over the view
        // view.setGridResolution(1);
        
        // display the view in a frame
        final JFrame frame = new JFrame("Multi-level game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel, BorderLayout.EAST);
        
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        
        // view tarcks the Player
        world.addStepListener(new Tracker(view, world.getPlayer()));

        // debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        world.start();
    }

        /** The player in the current level.
     * @return  */
    public Player getPlayer() {
        return world.getPlayer();
    }
        /** The games current level
     * @return  */
    public int getLevelCount(){
        return level;
    }
    
    /** Is the current level of the game finished?
     * @return  */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if(level == 2){
            gameMusic2.stop();
            gameMusic3.play();
            level++;
            int currentScore = world.getPlayer().getScore();
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            world.getPlayer().setScore(currentScore);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);

            world.start();
            world.addStepListener(new Tracker(view, world.getPlayer()));
        }
        else if (level == 1)  {
            gameMusic1.stop();
            gameMusic2.play();
            level++;
            int currentScore = world.getPlayer().getScore();
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            world.getPlayer().setScore(currentScore);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            
            world.start();
            world.addStepListener(new Tracker(view, world.getPlayer()));
        } else if (level ==3){
            gameMusic3.stop();
            gameMusic4.play();
            level++;
            int currentScore = world.getPlayer().getScore();
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            world.getPlayer().setScore(currentScore);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);

            world.start();
            world.addStepListener(new Tracker(view, world.getPlayer()));
        }else if (level == 4 ){
            try {
                System.out.println("Congrates you finshed the the game ;_;");
                writeScore();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     *
     * @throws IOException
     */
    public void writeScore() throws IOException{
        String player_name = JOptionPane.showInputDialog("What is your name?");
        HighScoreWriter hw = new HighScoreWriter("highscore.txt");
        hw.writeHighScore(player_name, getPlayer().getScore(), level);
    }
    
    /**
     *
     * @throws IOException
     */
    public void readScore() throws IOException{
        highScoreReader = new HighScoreReader("highscore.txt");
        highScoreReader.readScores();
    }  

    /**
     * 
     * @return HighScoreReader
     */
    public HighScoreReader getHighScoreReader() {
        return highScoreReader;
    }
    
    /** Run the game.
     * @param args */
    public static void main(String[] args) {
        new Game();
     
        
    }
}
