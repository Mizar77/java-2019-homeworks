package gui;

import java.awt.*;

public class WrappedDrawableComponent<T extends Drawable> extends WrappedComponent<T> {
    public WrappedDrawableComponent() {
    }

    public WrappedDrawableComponent(Rectangle bounds) {
        super(bounds);
    }

    public WrappedDrawableComponent(int x, int y, int width, int length) {
        super(x, y, width, length);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(get() != null){
            get().draw(g);
        }
    }
}
