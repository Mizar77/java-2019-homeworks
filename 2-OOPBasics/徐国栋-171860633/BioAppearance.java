import java.awt.Color;

public class BioAppearance {// 外观类，控制人物的一般外貌特征
    public Color color;

    public BioAppearance() {
        color = new Color(0, 0, 0);
    }

    public BioAppearance(Color _color) {
        color = _color;
    }

    public String color2String() { // 把RGB颜色映射到红橙黄绿青蓝紫
        if (color.equals(new Color(255, 0, 0)))
            return "红色";
        else if (color.equals(new Color(255, 128, 0)))
            return "橙色";
        else if (color.equals(new Color(255, 255, 0)))
            return "黄色";
        else if (color.equals(new Color(0, 255, 0)))
            return "绿色";
        else if (color.equals(new Color(0, 255, 255)))
            return "青色";
        else if (color.equals(new Color(0, 0, 255)))
            return "蓝色";
        else if (color.equals(new Color(128, 0, 255)))
            return "紫色";
        else
            return "其它颜色";
    }

    public int color2intForSort() {
        if (color.equals(new Color(255, 0, 0)))
            return 0;
        else if (color.equals(new Color(255, 128, 0)))
            return 1;
        else if (color.equals(new Color(255, 255, 0)))
            return 2;
        else if (color.equals(new Color(0, 255, 0)))
            return 3;
        else if (color.equals(new Color(0, 255, 255)))
            return 4;
        else if (color.equals(new Color(0, 0, 255)))
            return 5;
        else if (color.equals(new Color(128, 0, 255)))
            return 6;
        else
            return 0x3f3f3f3f;
    }
}