package gui;

import javax.swing.*;
import java.awt.*;

public class WrappedComponent<T> extends JButton {
    private T element;

    public WrappedComponent(){}

    public WrappedComponent(Rectangle bounds){
        super.setBounds(bounds);
    }

    public WrappedComponent(int x, int y, int width, int length){
        super.setBounds(x, y, width, length);
    }


    public T get() {
        return element;
    }

    public void set(T element) {
        this.element = element;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
}
