package bawei.com.myappkuaikan.fragment.fragment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.V_ViewPagerAdapter;
import bawei.com.myappkuaikan.utils.Urls;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class Fragment_guangchang extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list = new ArrayList<Fragment>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_v_gc,null);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addFragment();
        setAdapter();

    }

    private void setAdapter() {
        String[] tabs = new String[]{"热门","最新"};
        V_ViewPagerAdapter adapter = new V_ViewPagerAdapter(getActivity().getSupportFragmentManager(),
                list,tabs);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    private void addFragment() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        list.add(V_Fragment.getFragment(Urls.PATH_V_GC_HOT));
        list.add(V_Fragment.getFragment(Urls.PATH_V_GC_HOT));
    }

    private void initView() {
        tabLayout = (TabLayout)view.findViewById(R.id.tab_v);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_v);

    }
}
