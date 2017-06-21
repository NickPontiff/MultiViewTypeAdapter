package com.nickpontiff.multiviewtypeadapter.sample;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.nickpontiff.multiviewtypeadapter.sample.SampleViewType.VIEW_TYPE_ONE;
import static com.nickpontiff.multiviewtypeadapter.sample.SampleViewType.VIEW_TYPE_TWO;


@IntDef(value = {VIEW_TYPE_ONE, VIEW_TYPE_TWO})
@Retention(RetentionPolicy.SOURCE)
@interface SampleViewType {
    int VIEW_TYPE_ONE = 1;
    int VIEW_TYPE_TWO = 2;
}