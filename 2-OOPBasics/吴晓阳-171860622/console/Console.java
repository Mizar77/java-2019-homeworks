package console;

import creator.DrawableFigureCreator;
import creator.FigureCreator;
import figure.*;
import gui.*;

import javax.swing.*;
import java.awt.*;

public class Console {
    private GridFrame<DrawableFigure> mainFrame;

    public Console(){
        this.mainFrame = null;
    }

    public Console(GridFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void addMainFrame(GridFrame<DrawableFigure> mainFrame){
        this.mainFrame = mainFrame;
    }

    public void start(){
        mainFrame.loadFrame();
    }

    public GridFrame<DrawableFigure> getMainFrame(){
        return mainFrame;
    }

    public <T extends Figure> FigureHandler<T> createFigure(FigureCreator<T> creator, Image image ,Point position, Object... ctorArgs){
        T figure = creator.create(ctorArgs);
        DrawableFigure<T> drawFigure = new DrawableWrapper(figure, image);
        getMainFrame().getGridMap().get(position).set(drawFigure);
        return new FigureHandler<>(figure, image, position);
    }

    public <T extends DrawableFigure> FigureHandler<T> createFigure(FigureCreator<T> creator, Point position, Object... ctorArgs){
        T drawFigure = creator.create(ctorArgs);
        getMainFrame().getGridMap().get(position).set(drawFigure);
        return new FigureHandler<>(drawFigure, position);
    }

    public <T extends Figure> void moveFigure(FigureHandler<T> handler, Point dstPoint){
        checkHandler(handler);

        Point position = handler.getPosition();
        WrappedDrawableComponent<DrawableFigure> fromComponent = mainFrame.getGridMap().get(position);
        DrawableFigure figure = fromComponent.get();
        WrappedDrawableComponent<DrawableFigure> toComponent = mainFrame.getGridMap().get(dstPoint);

        fromComponent.set(null);
        toComponent.set(figure);

        handler.position = dstPoint;

        refresh();
    }

    public <T extends Figure> void removeFigure(FigureHandler<T> handler){
        checkHandler(handler);

        Point position = handler.position;
        mainFrame.getGridMap().get(position).set(null);

        handler.setDead();

        refresh();
    }

    /*
    * 清除显示和存储，但暂时不清除handler，以便之后使用move来嵌入
     */
    public <T extends Figure> void suspendFigure(FigureHandler<T> handler){
        checkHandler(handler);

        Point position = handler.position;
        mainFrame.getGridMap().get(position).set(null);

        handler.setSuspended(true);

        refresh();
    }

    /*
    * 从暂停中恢复，恢复至原本位置
     */
    public <T extends Figure> void recoverFigure(FigureHandler<T> handler){
        assert(checkAlive(handler) && checkNotSuspended(handler) == false);


        Point position = handler.position;
        DrawableFigure figure;
        if(handler.figure instanceof DrawableFigure){
            figure = (DrawableFigure)handler.figure;
        }
        else{
            figure = new DrawableWrapper(handler.figure, handler.image);
        }

        handler.setSuspended(false);

        refresh();
    }

    public <T extends Figure> void recoverFigure(FigureHandler<T> handler, Point dstPoint){
        assert(checkAlive(handler) && checkNotSuspended(handler) == false);

        handler.position = dstPoint;
        DrawableFigure figure;
        if(handler.figure instanceof DrawableFigure){
            figure = (DrawableFigure)handler.figure;
        }
        else{
            figure = new DrawableWrapper(handler.figure, handler.image);
        }
        mainFrame.getGridMap().get(dstPoint).set(figure);

        handler.setSuspended(false);

        refresh();
    }

    private boolean checkNotSuspended(FigureHandler handler){
        if(handler.suspended == true){
            assert(false);
            return false;
        }
        return true;
    }

    private boolean checkAlive(FigureHandler handler){
        return handler.alive;
    }

    private boolean checkHandler(FigureHandler handler){
        return checkAlive(handler) && checkNotSuspended(handler);
    }

    public void refresh(){
        SwingUtilities.invokeLater(()-> mainFrame.repaint());
    }

    public void clear(){
        mainFrame.clear();
    }

    public class FigureHandler<T extends Figure> {
        private T figure;

        private Image image;

        private Point position;

        private boolean suspended = false;

        private boolean alive = true;

        public FigureHandler(T figure, Point position){
            this.figure = figure;
            this.image = null;
            this.position = position;
        }

        public FigureHandler(T figure, Image image, Point position){
            this.figure = figure;
            this.image = image;
            this.position = position;
        }

        public T get(){
            return figure;
        }

        public Point getPosition(){
            return new Point(position);
        }

        public boolean isSuspended(){
            return suspended;
        }

        public boolean isAlive(){
            return alive;
        }

        private void setDead(){
            alive = false;
        }

        private void setSuspended(boolean flag){
            suspended = flag;
        }
    }
}
