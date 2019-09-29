package item;

import gui.Drawable;
import imgs.ImageRepository;

import java.awt.*;

/*
* 只有图像，没有支撑结构的item，在全局面板上绘画，因此需要获取自己的位置信息
* 绘图时是最高一层，因此不会与其它组件发生显示冲突
* position是像素的位置，不是格子的位置
* 注意：image必须自己调整到合适的大小
 */
public class DrawableItem<T extends Item> implements Item, Drawable {
    private T item;

    private Image image;

    private Point coordinace;

    public DrawableItem(T item, Image image){
        this.item = item;
        this.image = image;
        this.coordinace = null;
    }

    public DrawableItem(T item, Image image, Point coordinace){
        this.item = item;
        this.image = image;
        this.coordinace = coordinace;
    }

    public T getItem() {
        return item;
    }

    public Image getImage() {
        return image;
    }

    public Point getCoordinace(){
        return coordinace;
    }

    public void setCoordinace(Point coordinace){
        this.coordinace = coordinace;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, coordinace.x, coordinace.y, null);
    }
}
