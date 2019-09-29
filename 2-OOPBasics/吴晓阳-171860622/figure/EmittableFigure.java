package figure;

import creator.Creator;
import creator.ItemCreator;
import figure.feature.Emittable;
import item.DrawableItem;
import item.Item;
import sync.SyncGenerator;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
public class EmittableFigure<F extends Figure, I extends Item> implements Figure, Emittable<I> {
    private F figure;

    private SyncGenerator<I> generator;

    public EmittableFigure(F figure, SyncGenerator<I> generator) {
        this.figure = figure;
        this.generator = generator;

        generator.startGenerating();
    }

    @Override
    public String getName() {
        return figure.getName();
    }

    @Override
    public void setName(String name) {
        figure.getName();
    }

    @Override
    public boolean isEmittable() {
        return generator.isReady();
    }

    @Override
    public I emit() {
        return generator.fetch();
    }
}
