package figure;

import gui.Drawable;

import java.awt.*;

/*
* 可绘图的figure， 建立在Component的基础上，因此不需要自己存储位置信息，直接在Component的画布上绘画即可
 */
public interface DrawableFigure<T extends Figure> extends Drawable, Figure {
}
