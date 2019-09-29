package creator;

import figure.BasicFigure;

import java.lang.reflect.Constructor;
import java.util.NoSuchElementException;

public class BasicCreator<T> implements Creator<T> {
    Constructor<? extends T> ctor;

    public BasicCreator(Class<? extends T> type, Class<?>... ctorArgTypes){
        try {
            ctor = type.getConstructor(ctorArgTypes);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public T create(Object... args){
        T t = null;
        try {
            t = ctor.newInstance(args);
        }catch(Exception e){
            System.err.println("creation failed!");
        }
        return t;
    }
}
