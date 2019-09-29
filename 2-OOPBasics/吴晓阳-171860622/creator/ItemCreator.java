package creator;

import item.Item;

public class ItemCreator<T extends Item> extends BasicCreator<T> {
    public ItemCreator(Class<? extends T> type, Class<?>... ctorArgTypes) {
        super(type, ctorArgTypes);
    }
}
