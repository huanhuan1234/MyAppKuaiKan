package bawei.com.myappkuaikan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.FindFragmentAdapter;
import bawei.com.myappkuaikan.task.ResponesListener;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class FindFragment extends Fragment implements ResponesListener{

    private RelativeLayout pub_title2_id;
    private ViewPager viewPageer;
    private RadioGroup rg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, container, false);

        initView(view);

        return view;

    }

    private void initView(View view) {
        pub_title2_id = (RelativeLayout) view.findViewById(R.id.pub_title2_id);

        FindFragmentAdapter adapter = new FindFragmentAdapter(getActivity().getSupportFragmentManager());
        viewPageer.setAdapter(adapter);

        viewPageer = (ViewPager) view.findViewById(R.id.find_fragment2_viewpager);

        rg = (RadioGroup) view.findViewById(R.id.pub2_radiogroup);

        viewPageer.setCurrentItem(1);
        rg.check(R.id.pub_title2_right);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.pub_title2_left:
                        viewPageer.setCurrentItem(0);
//                        radiogroup.check(R.i`d.pub_title_left);
                        break;
                    case R.id.pub_title2_right:

                        viewPageer.setCurrentItem(1);
//                        radiogroup.check(R.id.pub_title_right);

                        break;

                }
            }
        });
        viewPageer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    rg.check(R.id.pub_title2_left);
                }else {
                    rg.check(R.id.pub_title2_right);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void sussess(String string) {

    }

    @Override
    public void onFail() {

    }
}
