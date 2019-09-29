package Main;

import console.Console;
import containers.HashGridMap;
import creator.*;
import figure.*;
import figure.finish.FinishedDawa;
import gui.Drawable;
import gui.GridFrame;
import gui.ItemedGridFrame;
import imgs.ImageRepository;
import item.BasicBullet;
import item.Bullet;
import item.DrawableBullet;
import item.Item;
import location.Direction;
import sort.BinarySort;
import sort.BubbleSort;

import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Console.FigureHandler<? extends Calabash>[] createRow(Console console, int row){
        FigureCreator<Calabash.Dawa> creator1 = new FigureCreator<>(Calabash.Dawa.class);
        FigureCreator<Calabash.Erwa> creator2 = new FigureCreator<>(Calabash.Erwa.class);
        FigureCreator<Calabash.Sanwa> creator3 = new FigureCreator<>(Calabash.Sanwa.class);
        FigureCreator<Calabash.Siwa> creator4 = new FigureCreator<>(Calabash.Siwa.class);
        FigureCreator<Calabash.Wuwa> creator5 = new FigureCreator<>(Calabash.Wuwa.class);
        FigureCreator<Calabash.Liuwa> creator6 = new FigureCreator<>(Calabash.Liuwa.class);
        FigureCreator<Calabash.Qiwa> creator7 = new FigureCreator<>(Calabash.Qiwa.class);

        Console.FigureHandler<? extends Calabash> handlers[] = new Console.FigureHandler[7];

        ArrayList<Point> positions = new ArrayList<>();
        positions.add(new Point(0, row));
        positions.add(new Point(1, row));
        positions.add(new Point(2, row));
        positions.add(new Point(3, row));
        positions.add(new Point(4, row));
        positions.add(new Point(5, row));
        positions.add(new Point(6, row));
        Collections.shuffle(positions);

        Dimension dimension = console.getMainFrame().getGridDimension();
        handlers[0] = console.createFigure(creator1, ImageRepository.getImage("Dawa",dimension), positions.get(0));
        handlers[1] = console.createFigure(creator2, ImageRepository.getImage("Erwa",dimension), positions.get(1));
        handlers[2] = console.createFigure(creator3, ImageRepository.getImage("Sanwa",dimension), positions.get(2));
        handlers[3] = console.createFigure(creator4, ImageRepository.getImage("Siwa",dimension), positions.get(3));
        handlers[4] = console.createFigure(creator5, ImageRepository.getImage("Wuwa",dimension), positions.get(4));
        handlers[5] = console.createFigure(creator6, ImageRepository.getImage("Liuwa",dimension), positions.get(5));
        handlers[6] = console.createFigure(creator7, ImageRepository.getImage("Qiwa",dimension), positions.get(6));

        return handlers;
    }

    public static void testItem(Console console){
    }

    public static void main(String[] args) throws Exception{
        Console console = new Console();
        GridFrame<DrawableFigure> frame = new ItemedGridFrame<>(10, 10,
                new HashGridMap<>(
                        new Dimension(10, 10)
                ));
        console.addMainFrame(frame);

        //testItem(console);

        console.start();

        Thread.sleep(1000);
        Console.FigureHandler<? extends Calabash>[] handlers = createRow(console, 0);
        console.refresh();

        Thread.sleep(1000);
        BubbleSort sort = new BubbleSort(console, handlers, 0);
        sort.sort();

        Thread.sleep(1000);
        handlers = createRow(console, 5);
        console.refresh();

        Thread.sleep(1000);
        BinarySort sort1 = new BinarySort(console, handlers, 5);
        sort1.sort();
    }
}
