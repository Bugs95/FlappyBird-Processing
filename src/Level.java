import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int backgroundColor;
    private int fallingSpeed;
    private int upSpeed;
    private List<Obstacle> obstacles = new ArrayList<>();

    Level(int backgroundColor, int fallingSpeed, int upSpeed, int numberOfObstacles) {
        this.backgroundColor = backgroundColor;
        this.fallingSpeed = fallingSpeed;
        this.upSpeed = upSpeed;

        setObstacles(numberOfObstacles);
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(int amount) {
        for (int i = 0; i < amount; i++) {
            obstacles.add(new Obstacle());
        }
    }

    public int getBackgroundColor() {
        return backgroundColor;

    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getFallingSpeed() {
        return fallingSpeed;
    }

    public void setFallingSpeed(int fallingSpeed) {
        this.fallingSpeed = fallingSpeed;
    }

    public int getUpSpeed() {
        return upSpeed;
    }

    public void setUpSpeed(int upSpeed) {
        this.upSpeed = upSpeed;
    }
}
