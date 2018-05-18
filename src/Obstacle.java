import processing.core.PApplet;

public class Obstacle extends PApplet{
    private int width;
    private int xPos;
    private int yPos;
    private int color;


    public Obstacle() {
        this.width = 100;
        this.xPos = 500;
        this.yPos = 300;
        this.color = 200;
    }


    public void paint() {
        fill(color);
        rect(width, width, xPos, yPos);
    }

}
