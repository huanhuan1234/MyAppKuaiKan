package bawei.com.myappkuaikan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.Mh_Adapter;
import bawei.com.myappkuaikan.fragment.fragment3.Fragment_guangchang;
import bawei.com.myappkuaikan.fragment.fragment3.Fragment_guanzhu;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class FeedFragment extends Fragment {

    private View view;
    private RadioGroup rg;
    private ViewPager v_vp;
    private List<Fragment> list_v = new ArrayList<Fragment>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.feed_fragment,null);

        rg = (RadioGroup) view.findViewById(R.id.rg);
        v_vp = (ViewPager) view.findViewById(R.id.v_vp);

        initData();
        setAdapter();

        v_vp.setCurrentItem(1);

        return view;
    }

    private void initData() {
        Fragment_guanzhu fragment_v_gz = new Fragment_guanzhu();
        list_v.add(fragment_v_gz);
        Fragment_guangchang fragment_v_gc = new Fragment_guangchang();
        list_v.add(fragment_v_gc);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        v_vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        v_vp.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    private void setAdapter() {
        v_vp.setAdapter(new Mh_Adapter(getActivity().getSupportFragmentManager(),list_v));
    }
}
