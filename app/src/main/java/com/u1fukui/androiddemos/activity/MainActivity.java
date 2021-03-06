package com.u1fukui.androiddemos.activity;

import com.u1fukui.androiddemos.DemoItem;
import com.u1fukui.androiddemos.DemoItemListAdapter;
import com.u1fukui.androiddemos.activity.animation.AnimationListActivity;
import com.u1fukui.androiddemos.activity.ui.keyboard.KeyboardListActivity;
import com.u1fukui.androiddemos.activity.ui.tab.TabListActivity;

import java.util.ArrayList;

public class MainActivity extends BaseListActivity {

    @Override
    protected DemoItemListAdapter createListAdapter() {
        ArrayList<DemoItem> itemList = new ArrayList<DemoItem>();
        itemList.add(new DemoItem(AnimationListActivity.class, "Animation"));
        itemList.add(new DemoItem(TabListActivity.class, "Tab"));
        itemList.add(new DemoItem(KeyboardListActivity.class, "Keyboard"));
        return new DemoItemListAdapter(this, itemList);
    }
}
