import processing.core.PApplet;
import processing.core.PImage;

class BackgroundScene {
    PApplet screen;
    String image_path = new String("data/Backgrounds/backgroundScene.png");

    PImage ground1;
    PImage ground2;
    int speed;

    int ground1_x;
    int ground1_y;

    int ground2_x;
    int ground2_y;

    BackgroundScene(PApplet screen){
        this.screen = screen;
        ground1 = screen.loadImage(image_path);
        ground2 = screen.loadImage(image_path);

        ground2_x = screen.width;
        ground2_y = 0;
        ground1_x = 0;
        ground1_y = 0;
        speed = 2;

    }

    void draw(){
        screen.image(ground1, ground1_x, ground1_y, screen.width, screen.height);
        screen.image(ground2, ground2_x, ground2_y, screen.width, screen.height);

        ground1_x = ground1_x - speed;
        ground2_x = ground2_x - speed;

        if(ground1_x <= -screen.width){
            ground1_x = screen.width + ground2_x;
        }

        if(ground2_x <= -screen.width){
            ground2_x = screen.width + ground1_x;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
