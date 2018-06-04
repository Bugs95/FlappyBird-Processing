import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Obstacle  {
    private int length;
    private int xPos;
    private int yPos;
    private int red, green, blue;
    private int speed;
    PApplet screen;
    Random rand;
    String imagePath;
    PImage obstacle;

    public Obstacle(PApplet screen, int speed) {
        this.screen = screen;
        String imagePath = new String("data/Backgrounds/obstacle.png");
        obstacle = screen.loadImage(imagePath);
        length = 50;
        rand = new Random();
        this.xPos = rand.nextInt(5000) + screen.width;
        this.yPos = rand.nextInt(screen.height - 100) + 50;
        this.speed = speed;
        }

    /**
     * Paint object
     */
    public void paint() {
        screen.image(obstacle, xPos, yPos, length, length);
        }

    public void move() {
        if (xPos > -20) {
            this.xPos -= speed;
        } else{
            // TODO remove Object from ArrayList
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public PApplet getScreen() {
        return screen;
    }

    public void setScreen(PApplet screen) {
        this.screen = screen;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public PImage getObstacle() {
        return obstacle;
    }

    public void setObstacle(PImage obstacle) {
        this.obstacle = obstacle;
    }
}
