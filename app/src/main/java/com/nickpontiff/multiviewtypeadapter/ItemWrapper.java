package com.nickpontiff.multiviewtypeadapter;

public class ItemWrapper {

    private Object item;

    public ItemWrapper(Object item) {
        this.item = item;
    }

    public <T> T getItem(Class<T> clazz) {
        return clazz.cast(item);
    }

    public Object getItemFromObject() {
        return item;
    }
}