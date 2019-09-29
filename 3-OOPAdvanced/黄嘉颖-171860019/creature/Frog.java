package creature;

import javafx.scene.image.Image;

public class Frog extends Demon {
    Frog(int number){
        switch (number){
            case 1:
                name = "蓝蛙精";
                picture=new Image("image/Bluefrog.png");
                picturePath = "image/Bluefrog.png";
                break;
            case 2:
                name = "棕蛙精";
                picture=new Image("image/Brownfrog.png");
                picturePath = "/image/Brownfrog.png";
                break;
            case 3:
                name = "紫蛙精";
                picture=new Image("image/Purplefrog.png");
                picturePath = "/image/Purplefrog.png";
                break;
            default:
                System.out.println("no extra frog!");
                break;
        }
    }
}
