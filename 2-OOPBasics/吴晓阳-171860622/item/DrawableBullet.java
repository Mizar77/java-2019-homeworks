package item;

import figure.Figure;
import location.Direction;
import location.LocationUtils;

import java.awt.*;

/*
* 可绘图的子弹，继承DrawableItem
* 指定了运行方向，使其可以朝着一个方向移动
* 重载了draw方法，使得其可以自动更新子弹位置
 */
public class DrawableBullet extends DrawableItem<Bullet> implements Bullet{

    private int speed;

    private Direction direction;

    private Point momentum;

    public DrawableBullet(Bullet bullet, Image image){
        super(bullet, image);
        this.speed = 10;
        this.direction = new Direction(0);
        this.momentum = LocationUtils.makeMomentum(direction, speed);
    }

    public DrawableBullet(Bullet bullet, Image image, Point position, int speed, Direction direction){
        super(bullet, image, position);
        this.speed = speed;
        this.direction = direction;
        this.momentum = LocationUtils.makeMomentum(direction, speed);
    }

    @Override
    public int getDamage() {
        return getItem().getDamage();
    }

    @Override
    public Figure getEmitter() {
        return getItem().getEmitter();
    }

    @Override
    public boolean interact(Figure figure) {
        return getItem().interact(figure);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        getCoordinace().translate(momentum.x, momentum.y);
    }
}
