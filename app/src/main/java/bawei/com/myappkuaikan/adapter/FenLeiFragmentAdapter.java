package bawei.com.myappkuaikan.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bawei.com.myappkuaikan.fragment.thrid.FenLeiFragmentTitile;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class FenLeiFragmentAdapter extends FragmentPagerAdapter {
    String[] arr ={"全部","恋爱","灵异","古风","爆笑","奇幻","校园","都市","少年","治愈","完结"};

    public FenLeiFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FenLeiFragmentTitile titile = new FenLeiFragmentTitile();
        Bundle bundle=new Bundle();
        bundle.putString("fenlei",arr[position]);
        titile.setArguments(bundle);
        return titile;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
