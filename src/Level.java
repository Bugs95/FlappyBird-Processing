import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is used to instanziate new levels
 */
public class Level {
    private int backgroundColor;
    private int fallingSpeed;
    private int upSpeed;
    private int obstacleSpeed;
    private List<Obstacle> obstacles = new ArrayList<>();
    PApplet screen;

    public int getObstacleSpeed() {
        return obstacleSpeed;
    }

    public void setObstacleSpeed(int obstacleSpeed) {
        this.obstacleSpeed = obstacleSpeed;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    Level(int backgroundColor, int fallingSpeed, int upSpeed, int numberOfObstacles, int obstacleSpeed, PApplet pApplet) {
        this.backgroundColor = backgroundColor;
        this.fallingSpeed = fallingSpeed;
        this.upSpeed = upSpeed;
        this.obstacleSpeed = obstacleSpeed;

        screen = pApplet;

        setObstacles(numberOfObstacles);
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(int amount) {
        for (int i = 0; i < amount; i++) {
            obstacles.add(new Obstacle(screen, obstacleSpeed));
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

    public void paintObstacles() {
        obstacles.forEach(Obstacle::paint);
    }

    public void moveObstacles() {
        obstacles.forEach(Obstacle::move);
    }
}
