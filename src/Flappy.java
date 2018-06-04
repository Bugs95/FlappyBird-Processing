import processing.core.PApplet;
import processing.core.PImage;

/**
 * this class provides flappy, the game's figure
 */
public class Flappy {
    PApplet screen;
    String image_path[];
    int flappySize;
    int life;
    PImage flappyImage[];
    int xPos;
    int yPos;
    int animationFrame;


    Flappy(PApplet screen) {
        this.screen = screen;
        image_path = new String[]{
                "data/CrappyBird/01.png",
                "data/CrappyBird/02.png",
                "data/CrappyBird/03.png",
                "data/CrappyBird/04.png",
                "data/CrappyBird/05.png",
                "data/CrappyBird/06.png",
                "data/CrappyBird/07.png",
                "data/CrappyBird/09.png",
                "data/CrappyBird/10.png",
                "data/CrappyBird/11.png",
                "data/CrappyBird/12.png",
                "data/CrappyBird/13.png",
                "data/CrappyBird/14.png",
                "data/CrappyBird/15.png",
                "data/CrappyBird/16.png",
                "data/CrappyBird/17.png",
                "data/CrappyBird/18.png",
                "data/CrappyBird/19.png"
        };
        xPos = screen.width / 4;
        yPos = screen.height / 3;
        animationFrame = 0;
        flappyImage = new PImage[image_path.length];
        for (int i = 0; i < image_path.length; i++) {
            flappyImage[i] = screen.loadImage(image_path[i]);
        }
        life = 300;
        flappySize = 100;
    }

    void draw() {
        screen.image(flappyImage[animationFrame], xPos, yPos, flappySize, flappySize);
        if (animationFrame < image_path.length - 1) {
            animationFrame++;
        } else {
            animationFrame = 0;
        }
    }


    public void fall() {
        if (getFlappySize() > 5) {
            setFlappySize(getFlappySize() - 5);
        } else {
            screen.stop();
        }
    }

    public int getFlappySize() {
        return flappySize;
    }

    public void setFlappySize(int flappySize) {
        this.flappySize = flappySize;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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


}