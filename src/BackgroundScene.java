import processing.core.PApplet;
import processing.core.PImage;

class BackgroundScene {
    PApplet screen;
    String image_path = "data/Backgrounds/backgroundScene.png";

    PImage ground1;
    PImage ground2;
    // TODO speeed?!?
    int speed = 0;

    int ground1_x = 0;
    int ground1_y = 0;

    int ground2_x = screen.width;
    int ground2_y = 0;

    BackgroundScene(){
        ground1 = screen.loadImage(image_path);
        ground2 = screen.loadImage(image_path);
    }

    void drawing(){
        screen.image(ground1, ground1_x, ground1_y, screen.width, screen.height);
        screen.image(ground2, ground2_x, ground2_y, screen.width, screen.height);
    }

    void act(){
        ground1_x = ground1_x - speed;
        ground2_x = ground2_x - speed;

        if(ground1_x <= -screen.width){
            ground1_x = screen.width + ground2_x;
        }

        if(ground2_x <= -screen.width){
            ground2_x = screen.width + ground1_x;
        }
    }

}
