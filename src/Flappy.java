import processing.core.PApplet;
import processing.core.PImage;

public class Flappy {
    PApplet screen;

    String image_path[] = {
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
            "data/CrappyBird/19.png",
    };

    int size = 150;
    float animation_time = 0.2f;
    int gravitation = 1;
    int jump = 30;
    int birdWidth;
    int life;

    PImage flappyImage[];
    int xPos;
    int yPos;
    int image_width;
    int image_height;
    int animation;
    float time;
    int y_velocity;

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }


    Flappy() {
        xPos = screen.width / 4;
        yPos = screen.height / 3;
        animation = 0;
        time = 0;
        flappyImage = new PImage[image_path.length];
        for (int i = 0; i < image_path.length; i++) {
            flappyImage[i] = screen.loadImage(image_path[i]);
        }
        birdWidth = 50;
        life = 500;

        y_velocity = 0;
    }

    void drawing() {
        image_width = size;
        image_height = size;
        screen.image(flappyImage[animation], xPos, yPos, image_width, image_height);
    }

    void act() {
        y_velocity = y_velocity + gravitation;
        yPos = yPos + y_velocity;

        float delta_time = 1 / screen.frameRate;
        time = time + delta_time;

        if (time >= animation_time) {
            animation++;
            if (animation >= image_path.length) {
                animation = 0;
            }
        }
    }

    public float getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public String[] getImage_path() {
        return image_path;
    }

    public void setImage_path(String[] image_path) {
        this.image_path = image_path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getAnimation_time() {
        return animation_time;
    }

    public void setAnimation_time(float animation_time) {
        this.animation_time = animation_time;
    }

    public int getGravitation() {
        return gravitation;
    }

    public void setGravitation(int gravitation) {
        this.gravitation = gravitation;
    }

    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    public int getBirdWidth() {
        return birdWidth;
    }

    public void setBirdWidth(int birdWidth) {
        this.birdWidth = birdWidth;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public PImage[] getFlappyImage() {
        return flappyImage;
    }

    public void setFlappyImage(PImage[] flappyImage) {
        this.flappyImage = flappyImage;
    }

    public int getImage_width() {
        return image_width;
    }

    public void setImage_width(int image_width) {
        this.image_width = image_width;
    }

    public int getImage_height() {
        return image_height;
    }

    public void setImage_height(int image_height) {
        this.image_height = image_height;
    }

    public int getAnimation() {
        return animation;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getY_velocity() {
        return y_velocity;
    }

    public void setY_velocity(int y_velocity) {
        this.y_velocity = y_velocity;
    }

    public PApplet getScreen() {
        return screen;
    }

    public void setScreen(PApplet screen) {
        this.screen = screen;
    }

    void jump() {
        y_velocity = -jump;
    }

}