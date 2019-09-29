package item;

import console.Console;
import figure.Figure;

/*
* 基本的子弹
* 可以与figure互动，降低其生命值
 */
public interface Bullet extends Item, Interactable {
    // 获取发射源
    Figure getEmitter();

    int getDamage();
}
