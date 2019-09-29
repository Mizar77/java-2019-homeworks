package gui;

import containers.GridMap;
import figure.DrawableFigure;
import figure.feature.Emittable;
import item.DrawableBullet;
import item.DrawableItem;
import item.Interactable;
import item.Item;

import java.awt.*;
import java.util.*;

/*
* 继承自原GridFrame，可装载figure
* 添加了Item存储器和处理器，可以处理item的情况
 */
public class ItemedGridFrame<T extends DrawableFigure> extends GridFrame<T>{

    private Collection<DrawableItem>  items = new HashSet<>();

    public ItemedGridFrame(int rowSize, int colSize, GridMap<WrappedDrawableComponent<T>> gridMap) {
        super(rowSize, colSize, gridMap);
    }

    public <T extends Item>void addItem(DrawableItem<T> item){
        items.add(item);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        processFigureEvents();

        processItemEvents();

        drawItems(g);

        repaint();

        try {
            Thread.sleep(30);
        }catch(InterruptedException e){}
    }

    /*
    * 画出items，然后处理item事件
     */
    private void drawItems(Graphics g){
        for(DrawableItem item: items){
            item.draw(g);
        }
    }

    /*
    * 处理figure的生成item的事件（具有该功能的figure会每隔一段时间生成item）
     */
    private void processFigureEvents(){
        getGridMap().forEach((position, component)->{
            DrawableFigure figure = component.get();
            if(figure instanceof Emittable){
                Emittable emitter = (Emittable)figure;
                // 可生成item
                if(emitter.isEmittable() == true){
                    Item item = emitter.emit();
                    // 判断是否为可绘item，若是则给其填上坐标后加入item集
                    if(item instanceof DrawableItem){
                        DrawableItem drawableItem = (DrawableItem)item;
                        drawableItem.setCoordinace(positionToCoordinance(position));
                        items.add(drawableItem);
                    }
                }
            }
        });
    }

    private void processItemEvents(){
        for(DrawableItem item: items){
            if(item instanceof Interactable){
                Point position = coordinanceToPosition(item.getCoordinace());

                //检查是否越界
                if(getGridMap().checkPosition(position) == false){
                    items.remove(item);
                    continue;
                }

                /* item与figure在同一格子里交互
                * 待扩展
                 */
                T drawableFigure = getDrawable(position);
                if(drawableFigure != null){
                    boolean res = ((Interactable)item).interact(drawableFigure);
                    if(res == false){
                        items.remove(item);
                    }
                }
            }
        }
    }

    private Point coordinanceToPosition(Point cooridinance){
        return new Point(cooridinance.x / getGridDimension().width,
                cooridinance.y / getGridDimension().height);
    }

    private Point positionToCoordinance(Point position){
        return new Point(position.x * getGridDimension().width + getGridDimension().width / 2,
                position.y * getGridDimension().height + getGridDimension().height / 2);
    }
}
