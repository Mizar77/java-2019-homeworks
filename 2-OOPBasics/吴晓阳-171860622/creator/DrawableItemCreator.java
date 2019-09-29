package creator;

import figure.DrawableFigure;
import item.DrawableItem;
import item.Item;

import java.awt.*;

@Deprecated
public class DrawableItemCreator<T extends Item> implements Creator<DrawableItem<T>> {
    ItemCreator<T> itemCreator;

    Image image;

    public DrawableItemCreator(ItemCreator<T> itemCreator, Image image){
        this.itemCreator = itemCreator;
        this.image = image;
    }

    public DrawableItem<T> create(Object... args){
        T figure = itemCreator.create(args);
        return new DrawableItem<>(figure, image);
    }

    public DrawableItem<T> create(Dimension dimension, Object... args){
        T figure = itemCreator.create(args);
        return new DrawableItem<>(figure, image);
    }
}
