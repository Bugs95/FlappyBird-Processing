import processing.core.PApplet;

import java.util.Random;

public class Obstacle  {
    private int length;
    private int xPos;
    private int yPos;
    private int red, green, blue;
    private int speed;
    PApplet screen;
    Random rand = new Random();


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

    public Obstacle(PApplet p, int speed) {
        screen= p;

        this.length = 30;
        this.xPos = rand.nextInt(5000) + 700;
        this.yPos = rand.nextInt(700) + 10;
        this.red = rand.nextInt(200) + 56;
        this.green = rand.nextInt(200) + 56;
        this.blue = rand.nextInt(200) + 56;
        this.speed = speed;
        }

    /**
     * Paint object
     */
    public void paint() {
        screen.fill(red, green, blue);
        screen.rect(xPos, yPos, length, length);
    }

    public void move() {
        if (xPos > -20) {
            this.xPos -= speed;
        } else{
            // TODO remove Object from ArrayList
        }
    }
}
