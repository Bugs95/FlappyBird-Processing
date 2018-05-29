import processing.core.PApplet;
import processing.core.PImage;
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
    //PShape image;
    int numFrames = 19;
    int currentFrame = 0;
    PImage[] images = new PImage[numFrames];

    // load different levels
    Level level1 = new Level(255, 5, 10, 10, 3, this);
    // TODO more levels
    Level level77 = new Level(243, 10, 15, 30, 10, this);

    public static void main(String[] args) {
        PApplet.main("FlappyBird", args);
    }


    public void settings() {
        //fullScreen();
        size(1200, 900);
        // TODO Interface and level system
    }


    public void setup() {
        noStroke();
        birdXPosition = width / 4;
        birdYPosition = height / 3;

        //load image 
        frameRate(40);

        images[0] = loadImage("src/Animation/01.png");
        images[1] = loadImage("src/Animation/02.png");
        images[2] = loadImage("src/Animation/03.png");
        images[3] = loadImage("src/Animation/04.png");
        images[4] = loadImage("src/Animation/05.png");
        images[5] = loadImage("src/Animation/06.png");
        images[6] = loadImage("src/Animation/07.png");
        images[7] = loadImage("src/Animation/08.png");
        images[8] = loadImage("src/Animation/09.png");
        images[9] = loadImage("src/Animation/10.png");
        images[10] = loadImage("src/Animation/11.png");
        images[11] = loadImage("src/Animation/12.png");
        images[12] = loadImage("src/Animation/13.png");
        images[13] = loadImage("src/Animation/14.png");
        images[14] = loadImage("src/Animation/15.png");
        images[15] = loadImage("src/Animation/16.png");
        images[16] = loadImage("src/Animation/17.png");
        images[17] = loadImage("src/Animation/18.png");
        images[18] = loadImage("src/Animation/19.png");

    }


    public void draw() {
        background(level1.getBackgroundColor());
        currentFrame = currentFrame + 1;
        if (currentFrame >= numFrames) {
            currentFrame = 0;
        }
        image(images[currentFrame], birdXPosition, birdYPosition);


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

    /*

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
