package figure;

import imgs.ImageRepository;

import java.awt.*;

public class DrawableWrapper<T extends Figure> implements DrawableFigure<T>{
    public T figure;

    public Image image;

    public DrawableWrapper(T figure, Image image){
        this.figure = figure;
        this.image = image;
    }

    @Override
    public String getName() {
        return figure.getName();
    }

    @Override
    public void setName(String name) {
        figure.setName(name);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
