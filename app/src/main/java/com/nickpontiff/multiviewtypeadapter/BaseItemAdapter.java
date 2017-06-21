package com.nickpontiff.multiviewtypeadapter;

import java.util.Arrays;
import java.util.List;

public abstract class BaseItemAdapter extends BaseAdapter<ItemWrapper> {

    private List<Class<?>> itemClasses;

    protected BaseItemAdapter() {
        super();
        ViewTypes annotation = getClass().getAnnotation(ViewTypes.class);
        if (annotation != null) {
            //noinspection unchecked
            Class<?>[] itemsArray = annotation.items();
            this.itemClasses = Arrays.asList(itemsArray);
        }
    }

    @Override
    public int getItemViewType(int position) {
        for (Class<?> clazz : itemClasses) {
            if ((getItems().get(position).getItemFromObject()).getClass() == clazz) {
                int index = itemClasses.indexOf(clazz);
                return getViewTypes().get(index);
            }
        }
        throw new IllegalStateException("Invalid view type");
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        //noinspection unchecked
        baseViewHolder.bindItem(getItem(i));
    }

    private <T> T getItem(int position) {
        if (itemClasses != null) {
            int index = getViewTypes().indexOf(getItemViewType(position));
            //noinspection unchecked
            Class<T> clazz = (Class<T>) itemClasses.get(index);
            return getItemCast(position, clazz);
        } else {
            throw new IllegalStateException("Cannot cast item without annotation");
        }
    }

    private <T> T getItemCast(int position, Class<T> clazz) {
        ItemWrapper itemWrapper = getItems().get(position);
        return itemWrapper.getItem(clazz);
    }
}