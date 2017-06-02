package bawei.com.myappkuaikan.fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.task.ResponesListener;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class FenLeiFragment extends Fragment {

//    private TabLayout tablayout;
//    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fenlei_fragment, container, false);
        //initView(view);
        return view;
    }

//    private void initView(View view) {
//        tablayout = (TabLayout) view.findViewById(R.id.fenlei_fragment_tablayout);
//        viewPager = (ViewPager) view.findViewById(R.id.fenlei_fragment_viewpager);
//        tablayout.setupWithViewPager(viewPager);
//        //选中何为选中的状态变色字体变色
//        tablayout.setTabTextColors(getResources().getColor(R.color.cgray),getResources().getColor(R.color.coffer));
//        //设置指示行的颜色
//        tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_bg));
//
//        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//    }


}
