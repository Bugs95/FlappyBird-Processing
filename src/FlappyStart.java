import processing.core.PApplet;

/**
 * @author Baumgarntner Louis, Brägger Luca, Kaufmann Tobias
 */

/**
 * This application is a Flappy Bird game where the player navigates a bird through different levels.
 * You can move the bird upwards by pressing any key.
 * Avoid collision with obstacles and have fun.
 */
public class FlappyStart extends PApplet {
    // global variables
    BackgroundScene background;
    Flappy flappy;
    Level level1;

    public static void main(String[] args) {
        PApplet.main("FlappyStart", args);
    }


    public void settings() {
        fullScreen();
        //size(1200, 720);
    }


    public void setup() {
        noStroke();
        level1 = new Level(255, 10, 30, 50, 10, this);

        // schwer
        //level1 = new Level(255, 20, 50, 100, 20, this);
        background = new BackgroundScene(this);
        flappy = new Flappy(this);
    }


    public void draw() {
        // paint background
        background.draw();

        // paint flappy
        flappy.draw();

        // paint life bar
        fill(255, 0, 0);
        if (flappy.getLife() > 0) {
            rect(flappy.getxPos(), flappy.getyPos() + 100, flappy.getLife() / 2, 25);
        }

        // paint obstacles
        level1.paintObstacles();
        level1.moveObstacles();

        // move bird up if any key is pressed
        if (flappy.life > 0) {
            if (keyPressed) {
                flappy.setyPos(flappy.getyPos() - level1.getUpSpeed());
            }
            flappy.setyPos(flappy.getyPos() + level1.getFallingSpeed());
            checkBoundary();
        } else {
            flappy.setyPos(flappy.getyPos() + 30);
            flappy.fall();
        }


        // check for collision with an object
        collisionDetection();
    }


    /**
     * check if Flappy Bird collided with an object
     */
    private void collisionDetection() {
        for (int i = 0; i < level1.getObstacles().size(); i++) {
            Obstacle obstacle = level1.getObstacles().get(i);
            if ((flappy.getxPos() + flappy.getFlappySize()) > obstacle.getxPos() &&
                    flappy.getxPos() < (obstacle.getxPos() + obstacle.getLength()) &&
                    (flappy.getyPos() + flappy.getFlappySize()) > obstacle.getyPos() &&
                    flappy.getyPos() < (obstacle.getyPos() + obstacle.getLength())) {
                textSize(50);
                text("AAAAAAHHHHH", flappy.getxPos(), flappy.getyPos());
                fill(0, 20, 20);
                flappy.setLife(flappy.getLife() - 10);
                if (flappy.getLife() <= 0) {
                    endGame();
                }
            }
        }
    }


    /**
     * Checks if flappy is outside the visible area.
     * If so the bird reenters on the other side.
     */
    public void checkBoundary() {
        if (flappy.getyPos() <= 0) {
            flappy.setyPos(height);
        } else if (flappy.getyPos() > height) {
            flappy.setyPos(0);
        }
    }

    public void endGame() {
        text("Du bist Scheisse!!", random(50, 300), random(500, 300));
    }
}
