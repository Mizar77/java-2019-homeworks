package sort;

import console.Console;
import figure.Calabash;

import java.awt.*;

public class BubbleSort {
    Console console;

    Console.FigureHandler<? extends Calabash>[] handlers;

    Console.FigureHandler<? extends Calabash>[] handlers2 = new Console.FigureHandler[7];

    int row;

    public BubbleSort(Console console, Console.FigureHandler<? extends Calabash>[] handlers, int row){
        this.console = console;

        this.handlers = handlers;

        this.row = row;
    }

    public void sort(){
        makeArray();

        doSort();

        speak();

    }

    private void makeArray(){
        for(int i = 0; i < 7; i++){
            int x = handlers[i].getPosition().x;
            handlers2[x] = handlers[i];
        }
    }

    private void doSort(){
        for(int i = 0; i < 7; i++){
            for(int j = i + 1; j < 7; j++){
                int cmpRes = handlers2[i].get().compareTo(handlers2[j].get());
                if(cmpRes > 0){
                    swap(i, j);
                }
            }
        }
    }

    private void speak(){
        for(Console.FigureHandler handler: handlers2){
            Calabash calabash = (Calabash)handler.get();
            calabash.speakOutSeniority();
        }
        System.out.println();
    }

    private void swap(int i, int j){
        Calabash calabash1 = handlers2[i].get();
        Calabash calabash2 = handlers2[j].get();

        info(calabash1, Integer.toString(i), "air");
        console.moveFigure(handlers2[i], new Point(j, row + 1));
        sleep(0.5);

        info(calabash2, Integer.toString(j), Integer.toString(i));
        console.moveFigure(handlers2[j], new Point(i, row));
        sleep(0.5);

        info(calabash1, "air", Integer.toString(j));
        console.moveFigure(handlers2[i], new Point(j, row));
        sleep(0.5);

        Console.FigureHandler tmpHandler = handlers2[i];
        handlers2[i] = handlers2[j];
        handlers2[j] = tmpHandler;
    }

    private void info(Calabash calabash, String i, String j){
        System.out.println(calabash + ": " + i + " -> " + j);
    }

    private void sleep(double second){
        try{
            Thread.sleep((long)(second * 1000));
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
