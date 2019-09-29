package creature;

import javafx.scene.image.*;

public class Snake extends Demon {
    public Snake(){
        name="蛇精";
        picturePath="image/Snake.png";
        picture=new Image("image/Snake.png");
        coordinateX=-1;
        coordinateY=-1;
    }
}
