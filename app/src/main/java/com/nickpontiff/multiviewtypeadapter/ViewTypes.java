package com.nickpontiff.multiviewtypeadapter;

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewTypes {

    int[] viewTypes() default 0;

    @LayoutRes int[] layouts() default 0;

    Class<? extends BaseViewHolder>[] viewHolders() default BaseViewHolder.class;

    Class<?>[] items() default Object.class;
}