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
    Level[] level;
    Level currentLevel;
    int counter;
    String levelText;

    public static void main(String[] args) {
        PApplet.main("FlappyStart", args);
    }


    public void settings() {
        fullScreen();
    }


    public void setup() {
        noStroke();
        level = new Level[3];

        // einfach
        level[0] = new Level(255, 10, 30, 50, 10, this);
        // mittel
        level[1] = new Level(255, 15, 40, 70, 15, this);
        // schwer
        level[2] = new Level(255, 20, 50, 100, 20, this);

        background = new BackgroundScene(this);
        flappy = new Flappy(this);
        currentLevel = level[0];
        levelText = new String("Level 1");
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

        // paint level text
        fill(212, 123, 156);
        textSize(100);
        text(levelText, 50, 100);

        // paint obstacles
        currentLevel.paintObstacles();
        currentLevel.moveObstacles();

        // move bird up if any key is pressed
        if (flappy.life > 0) {
            if (keyPressed) {
                flappy.setyPos(flappy.getyPos() - currentLevel.getUpSpeed());
            }
            flappy.setyPos(flappy.getyPos() + currentLevel.getFallingSpeed());
            checkBoundary();
        } else {
            flappy.setyPos(flappy.getyPos() + 30);
            flappy.fall();
        }

        collisionDetection();
        levelControl();
    }


    private void levelControl() {
        counter++;
        if (currentLevel == level[0] && counter > (5000 + this.width) / 10) {
            currentLevel = level[1];
            levelText = "Level 2";
            flappy.setLife(flappy.getLife() + 300);
            counter = 0;
        } else if (currentLevel == level[1] && counter > (5000 + this.width) / 15) {
            currentLevel = level[2];
            levelText = "Level 3";
            flappy.setLife(flappy.getLife() + 300);
            counter = 0;
        } else if (currentLevel == level[2] && counter > (5000 + this.width) / 20) {
            textSize(200);
            text("Sieg", this.width / 2, this.height / 2);
            fill(0, 20, 20);
        }
    }


    /**
     * check if Flappy collided with an object
     */
    private void collisionDetection() {
        for (int i = 0; i < currentLevel.getObstacles().size(); i++) {
            Obstacle obstacle = currentLevel.getObstacles().get(i);
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
        textSize(100);
        text("Verloren!!", random(50, 300), random(500, 300));
    }
}
