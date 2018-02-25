package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Simple character
 */
public class Player extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
        private static final Shape body = new PolygonShape(-0.139f,0.976f, 0.332f
                ,0.88f, 0.462f,0.087f, 0.409f,-0.942f, -0.615f,-0.947f, -0.683f,
                0.495f);
        
    SolidFixture PlayerFixture = new SolidFixture(this, body, 1);
    
    private static final BodyImage image =
        new BodyImage("data/large.gif", 3f);

    private int scoreCount;
    private int numberOfLives;
    private int score;
    private int jumpPower;
    private Controller controller;

 
    //private int powerUp;

    /**
     *
     * @param world is the world in which the body exist
     */

    public Player(World world) {
        super(world, body);
        addImage(image);
        PlayerFixture.setFriction(1);
        this.controller = controller;
        scoreCount = 0;
        numberOfLives = 7;
        jumpPower =20;
        score = 0;
    }

    /**
     *
     * @return the overall score of the game
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score 
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @return the current score count of the player in the level
     */
    public int scoreCount() {
        return scoreCount;
        
    }

    /**
     * the score count for the level will increase by 2 after picking up a coin or gem
     */
    public void incrementScoreCount() {
        scoreCount = scoreCount + 2;
        score = score + 2;
        System.out.println("Current Score = " + scoreCount +""+ "Overall Score = " + score);
    }
    
    /**
     *
     * @return the number of lives of the player
     */
    public int getNumberOfLives(){

        return numberOfLives;
    }
    
    /**
     * this decreases the player lives by one each time it has a collision
     */
    public void decreamentNumberOfLives(){
        numberOfLives--;
        System.out.println("Lives left " + numberOfLives);
    }
    
    /**
     * this increase the number of lives of the player by one each time
     */
    public void increamentNumberOfLives(){
        numberOfLives++;
    }
    
    /**
     * this reset the number of lives of the player
     */
    public void resetNumberOfLives(){
        numberOfLives = 5;
        System.out.println("You got blown up, try again" );
        this.setPosition(new Vec2(8,-5.0f));
    }
    
    /**
     * this reset the score of the player
     */
    public void resetScore(){
        scoreCount = 0;
        System.out.println("p.s Your score got reset, hahaha");   
}

    /**
     * a new game window is made
     */
    public void resetGame(){
        new Game();
    }
    
    /**
     * the game is closed
     */
    public void killGame(){
        System.out.println("Hahahahha you lost");
        System.exit(0);
    }
    
    
}