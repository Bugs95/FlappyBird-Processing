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


    // load different levels
    Level level1 = new Level(255, 5, 10, 10, 3, this);
    // TODO more levels
    Level level77 = new Level(243, 10, 15, 30, 10, this);

    public static void main(String[] args) {
        PApplet.main("FlappyStart", args);
    }


    public void settings() {
        //fullScreen();
        size(1200, 720);
        // TODO Interface and level system
    }


    public void setup() {
        noStroke();
//        background = new BackgroundScene();
        flappy = new Flappy();


    }


    public void draw() {
        background(level1.getBackgroundColor());
        rect(flappy.getxPos(), flappy.getyPos(), flappy.getBirdWidth(), flappy.getBirdWidth());

        //LifeBar
        fill(255, 0, 0);
        rect(flappy.getxPos(), flappy.getyPos() + 100, flappy.getLife(), 50);

        background.drawing();
        background.act();

        flappy.drawing();
        flappy.act();

        fill(255, 0, 0);
        rect(flappy.getxPos() - 50, flappy.getyPos() + 150, flappy.getLife(), 50);

        // paint obstacles
        level1.paintObstacles();
        level1.moveObstacles();

        // move bird up if any key is pressed
        if (keyPressed) {
            flappy.setyPos(flappy.getyPos() - level1.getUpSpeed());
        }
        flappy.setyPos(flappy.getyPos() + level1.getFallingSpeed());
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
            if ((flappy.getxPos() + flappy.getBirdWidth()) > obstacle.getxPos() &&
                    flappy.getxPos() < (obstacle.getxPos() + obstacle.getLength()) &&
                    (flappy.getyPos() + flappy.getBirdWidth()) > obstacle.getyPos() &&
                    flappy.getyPos() < (obstacle.getyPos() + obstacle.getLength())) {

                System.out.println("hahaha!");
                textSize(100);
                text("AAAAAAHHHHH", random(20, 200), random(20, 200));
                fill(0, 20, 20);
                text("Du bist Scheisse!!", random(50, 300), random(500, 300));
                flappy.setLife(flappy.getLife() - 10);
                if (flappy.getLife() == 0) {
                    exit();
                }
            }
        }
    }


    /**
     * Checks if the bird is outside the visible area.
     * If so the bird reenters on the other side.
     */
    public void checkBoundary() {
        if (flappy.getyPos() <= 0) {
            flappy.setyPos(height);
        } else if (flappy.getyPos() > height) {
            flappy.setyPos(0);
        }
    }
}
