package bawei.com.myappkuaikan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bawei.com.myappkuaikan.fragment.second.FenLeiFragment;
import bawei.com.myappkuaikan.fragment.second.TuijianFragment;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class FindFragmentAdapter extends FragmentPagerAdapter {
    public FindFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            TuijianFragment tuijianFragment = new TuijianFragment();
            return tuijianFragment;
        }else {
            FenLeiFragment fenLeiFragment = new FenLeiFragment();
            return fenLeiFragment;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
