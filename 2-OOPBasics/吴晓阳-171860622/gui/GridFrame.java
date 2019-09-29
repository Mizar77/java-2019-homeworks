package gui;

import containers.GridMap;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class GridFrame<T extends Drawable> extends BasicFrame {
    private int rowSize;

    private int colSize;

    private Dimension gridDimension;

    GridMap<WrappedDrawableComponent<T>> gridMap;

    public GridFrame(int rowSize, int colSize, GridMap<WrappedDrawableComponent<T>> gridMap){
        this.setLayout(null);
        this.getContentPane().setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.rowSize = rowSize;
        this.colSize = colSize;
        this.gridMap = gridMap;
        this.gridDimension = new Dimension(100, 100);

        this.initGridMap();
    }

    public void loadFrame(){
        setVisible(true);
    }

    public int getRowSize(){
        return rowSize;
    }

    public int getColSize(){
        return colSize;
    }

    public WrappedDrawableComponent<T> getWrappedDrawableComponent(Point position){
        return getGridMap().get(position);
    }

    public T getDrawable(Point position){
        return getGridMap().get(position).get();
    }

    public void setDrawable(Point position, T drawable){
        getGridMap().get(position).set(drawable);
    }

    public Dimension getGridDimension(){
        return gridDimension;
    }

    public GridMap<WrappedDrawableComponent<T>> getGridMap(){
        return gridMap;
    }

    private void initGridMap(){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < colSize; col++){
                Rectangle bounds = new Rectangle();
                bounds.x = row * gridDimension.width;
                bounds.y = col * gridDimension.height;
                bounds.width = gridDimension.width;
                bounds.height = gridDimension.height;
                WrappedDrawableComponent<T> component = new WrappedDrawableComponent<>(bounds);
                System.err.println(bounds);
                add(component); // 显示
                gridMap.put(new Point(row, col), component); // 实际存储
            }
        }
    }

    public void clear(){
        super.removeAll();
        gridMap.clear();
    }
}
