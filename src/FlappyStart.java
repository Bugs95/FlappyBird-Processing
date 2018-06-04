import processing.core.PApplet;

/**
 * @author Baumgarntner Louis, Brägger Luca, Kaufmann Tobias
 */

/**
 * This application is a an adaption to the flappy bird game where the player navigates a bird through different levels.
 * You can move flappy upwards by pressing any key.
 * Avoid collision with obstacles and have fun mastering all levels.
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
        level = new Level[10];

        level[0] = new Level(255, 10, 20, 40, 10, this);
        level[1] = new Level(255, 12, 25, 50, 12, this);
        level[2] = new Level(255, 15, 30, 60, 15, this);
        level[3] = new Level(255, 20, 35, 70, 17, this);
        level[4] = new Level(255, 24, 40, 80, 20, this);
        level[5] = new Level(255, 27, 45, 85, 22, this);
        level[6] = new Level(255, 30, 50, 90, 24, this);
        level[7] = new Level(255, 35, 60, 95, 26, this);
        level[8] = new Level(255, 40, 70, 100, 28, this);
        level[9] = new Level(255, 45, 80, 110, 30, this);

//        level[0] = new Level(255, 10, 20, 5, 10, this);
//        level[1] = new Level(255, 10, 20, 5, 12, this);
//        level[2] = new Level(255, 10, 20, 5, 15, this);
//        level[3] = new Level(255, 10, 20, 5, 17, this);
//        level[4] = new Level(255, 10, 20, 5, 20, this);
//        level[5] = new Level(255, 10, 20, 5, 22, this);
//        level[6] = new Level(255, 10, 20, 5, 24, this);
//        level[7] = new Level(255, 10, 20, 5, 26, this);
//        level[8] = new Level(255, 10, 20, 5, 28, this);
//        level[9] = new Level(255, 10, 20, 5, 30, this);

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
            rect(flappy.getxPos() + 30, flappy.getyPos() + 100, flappy.getLife() / 3, 20);
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

    /**
     * this method is used to control the selection and initialization of all levels
     */
    private void levelControl() {
        counter++;
        if (currentLevel == level[0] && counter > (5000 + this.width) / 10) {
            currentLevel = level[1];
            levelText = "Level 2";
            flappy.setLife(flappy.getLife() + 200);
            counter = 0;
            background.setSpeed(3);
        } else if (currentLevel == level[1] && counter > (5000 + this.width) / 12) {
            currentLevel = level[2];
            levelText = "Level 3";
            flappy.setLife(flappy.getLife() + 250);
            counter = 0;
            background.setSpeed(4);
        } else if (currentLevel == level[2] && counter > (5000 + this.width) / 15) {
            currentLevel = level[3];
            levelText = "Level 4";
            flappy.setLife(flappy.getLife() + 300);
            counter = 0;
            background.setSpeed(5);
        } else if (currentLevel == level[3] && counter > (5000 + this.width) / 17) {
            currentLevel = level[4];
            levelText = "Level 5";
            flappy.setLife(flappy.getLife() + 350);
            counter = 0;
            background.setSpeed(6);
        } else if (currentLevel == level[4] && counter > (5000 + this.width) / 20) {
            currentLevel = level[5];
            levelText = "Level 6";
            flappy.setLife(flappy.getLife() + 400);
            counter = 0;
            background.setSpeed(7);
        } else if (currentLevel == level[5] && counter > (5000 + this.width) / 22) {
            currentLevel = level[6];
            levelText = "Level 7";
            flappy.setLife(flappy.getLife() + 400);
            counter = 0;
            background.setSpeed(8);
        } else if (currentLevel == level[6] && counter > (5000 + this.width) / 24) {
            currentLevel = level[7];
            levelText = "Level 8";
            flappy.setLife(flappy.getLife() + 450);
            counter = 0;
            background.setSpeed(9);
        } else if (currentLevel == level[7] && counter > (5000 + this.width) / 26) {
            currentLevel = level[8];
            levelText = "Level 9";
            flappy.setLife(flappy.getLife() + 450);
            counter = 0;
            background.setSpeed(10);
        } else if (currentLevel == level[8] && counter > (5000 + this.width) / 28) {
            currentLevel = level[9];
            levelText = "Level 10";
            flappy.setLife(flappy.getLife() + 500);
            counter = 0;
            background.setSpeed(12);
        } else if (currentLevel == level[9] && counter > (5000 + this.width) / 20) {
            fill(0, 20, 20);
            textSize(200);
            text("Sieg", this.width / 2, this.height / 2);
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
