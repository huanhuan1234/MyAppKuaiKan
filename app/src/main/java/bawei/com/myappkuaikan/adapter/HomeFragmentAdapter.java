package bawei.com.myappkuaikan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bawei.com.myappkuaikan.fragment.second.FocusFragment;
import bawei.com.myappkuaikan.fragment.second.HotFragment;

/**
 * Created by huanhuan on 2017/4/26.
 */

public class HomeFragmentAdapter extends FragmentPagerAdapter {

    public HomeFragmentAdapter(FragmentManager fragmentManager){

        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int position) {
        if (position==0){
            FocusFragment focusFragment = new FocusFragment();
            return focusFragment;
        }else {
            HotFragment hotFragment = new HotFragment();
            return hotFragment;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
