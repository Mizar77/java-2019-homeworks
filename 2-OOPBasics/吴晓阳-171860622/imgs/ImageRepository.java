package imgs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageRepository {

    private static Map<String, Image> imgs = new HashMap<>();

    private static boolean inited = false;

    private static Image getImageWithoutCheck(String key){
        Image image = null;

        image = imgs.get(key);
        if(image != null) {
            return image;
        }

        image = addImage(key, ".jpg");

        return image;
    }

    private static boolean checkInit(){
        if(inited == false){
            imgs.put("Dawa", addImage("src/Dawa", ".jpg"));
            imgs.put("Erwa", addImage("src/Erwa", ".jpg"));
            imgs.put("Sanwa", addImage("src/Sanwa",".jpg"));
            imgs.put("Siwa", addImage("src/Siwa",".jpg"));
            imgs.put("Wuwa", addImage("src/Wuwa",".jpg"));
            imgs.put("Liuwa", addImage("src/Liuwa",".jpg"));
            imgs.put("Qiwa", addImage("src/Qiwa",".jpg"));
            imgs.put("Bullet", addImage("src/Bullet", ".jpg"));
            inited = true;
            return false;
        }
        return true;
    }

    private static Image createImage(Image image, int width, int height){
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return newImage;
    }

    public static Image addImage(String key, String postfix){
        Image originImage = null;
        try{
            originImage = ImageIO.read(new File(key + postfix));
        } catch (IOException e){}
        if(originImage != null){
            imgs.put(key, originImage);
        }

        return originImage;
    }

    public static Image addImage(String key, String postfix, Dimension dimension){
        Image originImage = null;
        try{
            originImage = ImageIO.read(new File(key + postfix));
        } catch (IOException e){}
        if(originImage != null){
            imgs.put(key, originImage);
        }

        return originImage;
    }

    public static Image getImage(String key){
        checkInit();

        Image oldImage = getImageWithoutCheck(key);
        if(oldImage == null) return null;

        Image image = createImage(oldImage, oldImage.getWidth(null), oldImage.getHeight(null));
        return image;
    }

    public static Image getImage(String key, Dimension dimension){
        checkInit();

        Image oldImage = getImageWithoutCheck(key);
        if(oldImage == null) return null;
        
        Image image = createImage(oldImage, dimension.width, dimension.height);
        return image;
    }
}
