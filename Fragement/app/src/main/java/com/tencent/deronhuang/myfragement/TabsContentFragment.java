package com.tencent.deronhuang.myfragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by deronhuang on 2018/7/24.
 */

public class TabsContentFragment extends ListFragment {

    public static TabsContentFragment newInstance(String tabIndex){
        TabsContentFragment tcf = new TabsContentFragment();

        Bundle args = new Bundle();
        args.putString("tabIndex",tabIndex);
        tcf.setArguments(args);

        return tcf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayList<String> content = new ArrayList<String>();
        if (getArguments() != null){
            String tabID = getArguments().getString("tabIndex");
            switch (tabID){
                case "Coupons":
                    content.add(0,"0");
                    content.add(1,"1");
                    content.add(2,"2");
                    break;
                case "Cashback":
                    content.add(0,"3");
                    content.add(1,"4");
                    content.add(2,"5");
                    break;
                default:
                    content.add(0,"6");
                    content.add(1,"7");
                    content.add(2,"8");
                    break;
            }
        }

        ListView listView = new ListView(getActivity());
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,content));
        return listView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
