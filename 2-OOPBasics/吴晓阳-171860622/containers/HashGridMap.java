package containers;

import java.awt.*;
import java.util.HashMap;

public class HashGridMap<T> extends HashMap<Point, T> implements GridMap<T> {
    private Dimension dimension;

    public HashGridMap(Dimension dimension){
        this.dimension = dimension;
    }

    @Override
    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public T get(Object point){
        if(checkPosition((Point)point) == false){
            throw new NullPointerException();
        }
        return super.get(point);
    }

    @Override
    public boolean checkPosition(Point point){
        if(point.x < 0 || point.x >= dimension.width
        || point.y < 0 || point.y >= dimension.height){
            return false;
        }
        return true;
    }
}
