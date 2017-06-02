package bawei.com.myappkuaikan.fragment.second;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.HotFragmentAdapter;
import bawei.com.myappkuaikan.event.ScrollEvent;
import bawei.com.myappkuaikan.utils.DateUtil;

/**
 * Created by huanhuan on 2017/4/26.
 */

public class HotFragment extends Fragment {

    private ViewPager viewpager;
    private TabLayout tablayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.hot_fragment,container,false);
        init(view);


        return view;
    }

    private void init(View view) {

        tablayout = (TabLayout) view.findViewById(R.id.hot_fragment_tablayout);
        viewpager =   (ViewPager) view.findViewById(R.id.hot_fragment_viewpager);

        HotFragmentAdapter adapter = new HotFragmentAdapter(getChildFragmentManager(),DateUtil.getData());
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(adapter.getCount()-1);
        //让viewpager和tablayout关联起来
        tablayout.setupWithViewPager(viewpager);
        //选中何为选中的状态变色字体变色
        tablayout.setTabTextColors(getResources().getColor(R.color.cgray),getResources().getColor(R.color.coffer));
        //设置指示行的颜色
        tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_bg));

        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        EventBus.getDefault().register(this);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onScrollEvent(ScrollEvent event){
        if (event.isUp()){
            if(tablayout.getVisibility() == View.GONE){
                return;
            }

            ObjectAnimator anim = ObjectAnimator.ofFloat(tablayout, "y", tablayout.getY(),
                    tablayout.getY() - tablayout.getHeight());
            anim.setDuration(500);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    tablayout.setVisibility(View.GONE);

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            anim.start();
        }else {
            if(tablayout.getVisibility() == View.VISIBLE){
                return;
            }

            tablayout.setVisibility(View.VISIBLE);

            ObjectAnimator anim = ObjectAnimator.ofFloat(tablayout, "y", tablayout.getY(),
                    tablayout.getY() + tablayout.getHeight());
            anim.setDuration(500);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    tablayout.setVisibility(View.VISIBLE);

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            anim.start();
        }
    }

}
