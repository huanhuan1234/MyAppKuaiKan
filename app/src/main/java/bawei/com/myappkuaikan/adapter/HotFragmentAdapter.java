package bawei.com.myappkuaikan.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.bean.WeekInfoBean;
import bawei.com.myappkuaikan.fragment.thrid.WeekFragment;
import bawei.com.myappkuaikan.utils.DateUtil;

/**
 * Created by huanhuan on 2017/4/26.
 */

public class HotFragmentAdapter extends FragmentPagerAdapter {
    List<WeekInfoBean> list;
    Context context;
    String[] TITLE= DateUtil.initWeek();

//    FragmentManager fragmentManager;
//    List<WeekInfoBean> list;


    public HotFragmentAdapter(FragmentManager childFragmentManager, List<WeekInfoBean> data) {
        super(childFragmentManager);
        this.list = data;
    }

    @Override
    public Fragment getItem(int position) {
        WeekFragment weekFragment = new WeekFragment();
        Bundle bundle = new Bundle();
        bundle.putString("week", String.valueOf(list.get(position).getDaytime()));

        weekFragment.setArguments(bundle);
        return weekFragment;
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}
