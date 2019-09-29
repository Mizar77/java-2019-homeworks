package figure.feature;

import item.Item;

/*
* 可以发射item
 */
public interface Emittable<T extends Item> {
    boolean isEmittable();

    T emit();
}
