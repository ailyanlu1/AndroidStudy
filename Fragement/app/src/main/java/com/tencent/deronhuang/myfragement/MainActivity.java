package com.tencent.deronhuang.myfragement;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getTabContent("");

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabL);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tabID = (String)tab.getText();
                MainActivity.this.getTabContent(tabID);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void getTabContent(String tabIndex) {
        TabsContentFragment tbC = TabsContentFragment.newInstance(tabIndex);

        FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
        tf.replace(R.id.tabContent,tbC);
        tf.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        tf.commit();
    }
}
