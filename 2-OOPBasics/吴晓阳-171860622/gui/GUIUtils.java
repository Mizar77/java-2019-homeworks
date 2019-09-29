package gui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GUIUtils {
    public static Image resizeImage(Image image, Dimension dimension){
        BufferedImage resImage = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = resImage.getGraphics();
        graphics.drawImage(image, 0, 0, dimension.width, dimension.height, null);
        graphics.dispose();
        return resImage;
    }
}
