package item;

import figure.Figure;
import figure.feature.Lifable;

public class BasicBullet implements Bullet{
    private int damage;

    private Figure emitter;

    public BasicBullet(){
        this.damage = 10;
        this.emitter = null;
    }

    public BasicBullet(int damage, Figure emitter){
        this.damage = damage;
        this.emitter = emitter;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public Figure getEmitter() {
        return emitter;
    }

    /*
    * 默认的interact操作
    * 减少figure生命值
    * 效果发生后消失
     */
    @Override
    public boolean interact(Figure figure) {
        // 遇到非发射者时释放效果，遇到发射者不影响
        if(getEmitter() != figure) {
            if (figure instanceof Lifable) {
                ((Lifable)figure).diminishLife(damage);
            }
            return false;
        }
        return true;
    }
}
