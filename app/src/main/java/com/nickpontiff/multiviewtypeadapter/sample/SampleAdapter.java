package com.nickpontiff.multiviewtypeadapter.sample;

import com.nickpontiff.multiviewtypeadapter.BaseItemAdapter;
import com.nickpontiff.multiviewtypeadapter.R;
import com.nickpontiff.multiviewtypeadapter.ViewTypes;

import static com.nickpontiff.multiviewtypeadapter.sample.SampleViewType.VIEW_TYPE_ONE;
import static com.nickpontiff.multiviewtypeadapter.sample.SampleViewType.VIEW_TYPE_TWO;

@ViewTypes(
        viewTypes = {VIEW_TYPE_ONE, VIEW_TYPE_TWO},
        layouts = {R.layout.one, R.layout.two},
        viewHolders = {SampleViewHolderOne.class, SampleViewHolderTwo.class},
        items = {SampleItemOne.class, SampleItemTwo.class}
)
public class SampleAdapter extends BaseItemAdapter {

    public SampleAdapter() {

    }
}
