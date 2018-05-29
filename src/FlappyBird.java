import processing.core.PApplet;
import processing.core.PShape;

/**
 * @author Baumgarntner Louis, Brägger Luca, Kaufmann Tobias
 */

/**
 * This application is a Flappy Bird game where the player navigates a bird through different levels.
 * You can move the bird upwards by pressing any key.
 * Avoid collision with obstacles and have fun.
 */
public class FlappyBird extends PApplet {
    // global variables
    int birdXPosition;
    int birdYPosition;
    int birdWidth = 50;
    PShape image;

    // load different levels
    Level level1 = new Level(255, 5, 10, 10, 3, this);
    // TODO more levels
    Level level77 = new Level(243, 10, 15, 30, 10, this);

    public static void main(String[] args) {
        PApplet.main("FlappyBird", args);
    }


    public void settings() {
        //fullScreen();
        size(1200, 720);
        // TODO Interface and level system
    }


    public void setup() {
        noStroke();
        birdXPosition = width / 4;
        birdYPosition = height / 3;

        //load image 
        //image = loadShape("src/thumb.svg"); 

    }


    public void draw() {
        background(level1.getBackgroundColor());
        shape (image, birdXPosition, birdYPosition);

        // paint obstacles
        level1.paintObstacles();
        level1.moveObstacles();

        // move bird up if any key is pressed
        if (keyPressed) {
            birdYPosition -= level1.getUpSpeed();
        }
        birdYPosition += level1.getFallingSpeed();
        checkBoundary();

        // check for collision with an object
        collisionDetection();
    }


    /**
     * check if Flappy Bird collided with an object
     */
    private void collisionDetection() {
        for (int i = 0; i < level1.getObstacles().size(); i++) {
            Obstacle obstacle = level1.getObstacles().get(i);
            if ((birdXPosition + birdWidth) > obstacle.getxPos() &&
                    birdXPosition <  (obstacle.getxPos() + obstacle.getLength()) &&
                    (birdYPosition + birdWidth) > obstacle.getyPos() &&
                    birdYPosition < (obstacle.getyPos() + obstacle.getLength())){

                // TODO colision effect
                System.out.println("hahaha!");
            }
        }
    }


    /**
     * Checks if the bird is outside the visible area.
     * If so the bird reenters on the other side.
     */
    public void checkBoundary() {
        if (birdYPosition <= 0) {
            birdYPosition = height;
        } else if (birdYPosition > height) {
            birdYPosition = 0;
        }
    }
}
