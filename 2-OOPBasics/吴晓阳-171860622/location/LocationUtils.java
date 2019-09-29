package location;

import java.awt.*;
import java.util.Map;

public class LocationUtils {
    public static void makeMove(Point point, Direction direction, int length){
        Point momentum = makeMomentum(direction, length);
        point.translate(momentum.x, momentum.y);
    }

    public static Point makeMomentum(Direction direction, int length){
        return new Point((int)(length * Math.cos(direction.radian)),
                (int)(length * Math.sin(direction.radian)));
    }
}
