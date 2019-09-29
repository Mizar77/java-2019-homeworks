package creator;

import creator.Creator;
import creator.FigureCreator;
import figure.DrawableFigure;
import figure.DrawableWrapper;
import figure.Figure;
import imgs.ImageRepository;

import java.awt.*;

/*
* 创建figure，并给它加上Drawable装饰器
*/
@Deprecated
public class DrawableFigureCreator<T extends Figure> implements Creator<DrawableFigure<T>> {
    FigureCreator<T> figureCreator;

    Image image;

    public DrawableFigureCreator(FigureCreator<T> figureCreator, Image image){
        this.figureCreator = figureCreator;
        this.image = image;
    }

    public DrawableFigure<T> create(Object... args){
        T figure = figureCreator.create(args);
        return new DrawableWrapper<>(figure, image);
    }

    public DrawableFigure<T> create(Dimension dimension, Object... args){
        T figure = figureCreator.create(args);
        return new DrawableWrapper<>(figure, image);
    }
}
