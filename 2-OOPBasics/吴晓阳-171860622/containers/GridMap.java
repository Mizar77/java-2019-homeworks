package containers;

import java.awt.*;
import java.util.function.BiConsumer;

public interface GridMap<T>{
    Dimension getDimension();

    int size();

    T get(Object point);

    T put(Point point, T element);

    void forEach(BiConsumer<? super Point, ? super T> consumer);

    void clear();

    /*
    * 检查格子坐标是否处在允许坐标内
     */
    boolean checkPosition(Point point);
}
