package com.nickpontiff.multiviewtypeadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> items;


    private List<Class<? extends BaseViewHolder>> viewHolderClasses;
    private List<Integer> viewTypes;
    private List<Integer> layouts;

    BaseAdapter() {
        this.items = new ArrayList<>();
        ViewTypes annotation = getClass().getAnnotation(ViewTypes.class);
        if (annotation != null) {
            //noinspection unchecked
            Class<? extends BaseViewHolder>[] viewHolderClassArray = annotation.viewHolders();
            int[] viewTypeArray = annotation.viewTypes();
            int[] layoutArray = annotation.layouts();
            this.layouts = new ArrayList<>(getIntegerListFromArray(layoutArray));
            this.viewTypes = new ArrayList<>(getIntegerListFromArray(viewTypeArray));
            this.viewHolderClasses = Arrays.asList(viewHolderClassArray);
        } else {
            throw new IllegalArgumentException("Must specify ViewTypes");
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int viewType = getItemViewType(i);
        int index = viewTypes.indexOf(viewType);
        Class<? extends BaseViewHolder> viewHolderClass = viewHolderClasses.get(index);
        int layoutRes = layouts.get(index);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutRes, viewGroup, false);
        try {
            Constructor<? extends BaseViewHolder> constructor = viewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (Exception e) {
            throw new IllegalStateException("invalid view holder");
        }
    }

    public void setItems(List<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    List<Integer> getViewTypes() {
        return this.viewTypes;
    }

    public List<T> getItems() {
        return this.items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    private static List<Integer> getIntegerListFromArray(int[] ints) {
        List<Integer> intList = new ArrayList<>();
        for (int integer : ints) {
            intList.add(integer);
        }
        return intList;
    }
}
