package com.tencent.deronhuang.myfragement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by deronhuang on 2018/7/24.
 */

public class ForTabsPagerAdapter extends FragmentPagerAdapter {
    private String curTab = "";

    public ForTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        setCurrentTab(position);
        Fragment fg = TabsContentFragment.newInstance(getCurrentTab());
        return fg;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getCurrentTab();
    }

    public void setCurrentTab(int selected){
        switch (selected){
            case 1:
                curTab = "Coupons";
                break;
            case 2:
                curTab = "Cashback";
                break;
            default:
                curTab = "";
        }
    }
    public String getCurrentTab(){
        return curTab;
    }
}
