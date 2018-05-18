import processing.core.PApplet;

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

    // load different levels
    Level level1 = new Level(123, 5,10, 5);


    public static void main(String[] args) {
        PApplet.main("FlappyBird", args);
    }


    public void settings() {
        fullScreen();
    }


    public void setup() {
        noStroke();
        birdXPosition = width/3;
        birdYPosition = height/3;
    }


    public void draw() {
        background(level1.getBackgroundColor());
        rect(birdXPosition, birdYPosition, 50, 50);
        // TODO
        // level1.getObstacles().forEach(Obstacle::paint);

        if (keyPressed) {
            birdYPosition -= level1.getUpSpeed();
        }
        birdYPosition += level1.getFallingSpeed();
        checkBoundary();
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
