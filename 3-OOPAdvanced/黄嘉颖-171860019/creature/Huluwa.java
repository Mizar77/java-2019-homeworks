package creature;

import javafx.scene.image.*;

public class Huluwa extends Creature{
    private int rank;
    private String color;

    public Huluwa(int number){
        switch(number) {
            case 1:
                this.rank = 1;
                color = "红色";
                name = "老大";
                picture=new Image("image/Redwa.png");
                picturePath = "image/Redwa.png";
                break;
            case 2:
                this.rank = 2;
                color = "橙色";
                name = "老二";
                picture=new Image("image/Orangewa.png");
                picturePath = "/image/Orangewa.png";
                break;
            case 3:
                this.rank = 3;
                color = "黄色";
                name = "老三";
                picture=new Image("image/Yellowwa.png");
                picturePath = "/image/Yellowwa.png";
                break;
            case 4:
                this.rank = 4;
                color = "绿色";
                name = "老四";
                picture=new Image("image/Greenwa.png");
                picturePath = "/image/Greenwa.png";
                break;
            case 5:
                this.rank = 5;
                color = "青色";
                name = "老五";
                picture=new Image("image/Bluewa.png");
                picturePath = "/image/Bluewa.png";
                break;
            case 6:
                this.rank = 6;
                color = "蓝色";
                name = "老六";
                picture=new Image("image/Cyanwa.png");
                picturePath = "/image/Cyanwa.png";
                break;
            case 7:
                this.rank = 7;
                color = "紫色";
                name = "老七";
                picture=new Image("image/Purplewa.png");
                picturePath = "/image/Purplewa.png";
                break;
            default:
                System.out.println("wrong huluwa number!");
                break;
        }
    }

    public int getRank() {
        return rank;
    }
}
