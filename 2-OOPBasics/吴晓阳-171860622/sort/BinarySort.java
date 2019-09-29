package sort;

import console.Console;
import figure.Calabash;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySort {
    Console console;

    Console.FigureHandler<? extends Calabash>[] handlers;

    Console.FigureHandler<? extends Calabash>[] handlers2 = new Console.FigureHandler[7];

    int row;

    public BinarySort(Console console, Console.FigureHandler<? extends Calabash>[] handlers, int row){
        this.console = console;

        this.handlers = handlers;

        this.row = row;
    }

    public void sort(){
        makeArray();

        doSort();

        speek();

    }

    private void makeArray(){
        for(int i = 0; i < 7; i++){
            int x = handlers[i].getPosition().x;
            handlers2[x] = handlers[i];
        }
    }

    public void doSort(){
        ArrayList<Calabash> calabashes = new ArrayList<>();
        for(Console.FigureHandler handler: handlers2){
            calabashes.add((Calabash)handler.get());
        }

        for(int i = 0; i < 7; i++){
            int index = Collections.binarySearch(calabashes.subList(0, i), calabashes.get(i));
            if(index < 0){
                index = -index - 1;
            }
            if(i != index) {
                insert(calabashes, i, index);
            }
        }
    }

    private void speek(){
        for(Console.FigureHandler handler: handlers2){
            Calabash calabash = (Calabash)handler.get();
            calabash.speakOutColor();
        }
        System.out.println();
    }

    private void insert(ArrayList<Calabash> calabashes, int fromIndex, int toIndex){
        Console.FigureHandler handler = handlers2[fromIndex];
        Calabash calabash = calabashes.get(fromIndex);

        info(calabashes.get(fromIndex), Integer.toString(fromIndex), "air");
        console.moveFigure(handlers2[fromIndex], new Point(toIndex, row + 1));

        handlers2[fromIndex] = null;
        calabashes.set(fromIndex, null);

        sleep(0.5);

        for(int i = fromIndex - 1; i >= toIndex; i--){
            info(calabashes.get(i), Integer.toString(i), Integer.toString(i + 1));
            console.moveFigure(handlers2[i], new Point(i + 1, row));

            handlers2[i + 1] = handlers2[i];
            calabashes.set(i + 1, calabashes.get(i));

            sleep(0.5);
        }

        info(calabash, "air", Integer.toString(toIndex));
        console.moveFigure(handler, new Point(toIndex, row));

        handlers2[toIndex] = handler;
        calabashes.set(toIndex, calabash);

        sleep(0.5);
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
