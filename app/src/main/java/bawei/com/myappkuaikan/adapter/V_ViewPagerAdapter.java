package bawei.com.myappkuaikan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */

public class V_ViewPagerAdapter extends FragmentPagerAdapter{
    private final List<Fragment> list;
    private final String[] title;

    public V_ViewPagerAdapter(FragmentManager fm, List<Fragment> list,String[] title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position % title.length];
    }
}
