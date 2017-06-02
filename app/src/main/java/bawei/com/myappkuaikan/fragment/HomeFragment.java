package bawei.com.myappkuaikan.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.HomeFragmentAdapter;
import bawei.com.myappkuaikan.event.ScrollEvent;
import bawei.com.myappkuaikan.task.ResponesListener;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class HomeFragment extends Fragment implements ResponesListener{

    private ViewPager viewpager;
    private RadioGroup radiogroup;
    private RelativeLayout pub_title_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);


        initView(view);
        return view;


    }

    private void initView(View view) {

        pub_title_id = (RelativeLayout) view.findViewById(R.id.pub_title_id);

        viewpager = (ViewPager) view.findViewById(R.id.home_fragment_viewpager);
        HomeFragmentAdapter adapter = new HomeFragmentAdapter(getActivity().getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        radiogroup = (RadioGroup) view.findViewById(R.id.pub_radiogroup);
        viewpager.setCurrentItem(1);

        radiogroup.check(R.id.pub_title_right);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.pub_title_left:
                        viewpager.setCurrentItem(0);
//                        radiogroup.check(R.i`d.pub_title_left);
                        break;
                    case R.id.pub_title_right:

                        viewpager.setCurrentItem(1);
//                        radiogroup.check(R.id.pub_title_right);

                        break;

                }
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    if (position==0){
                        radiogroup.check(R.id.pub_title_left);
                    }else {
                        radiogroup.check(R.id.pub_title_right);

                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        EventBus.getDefault().register(this);


    }
    //该方法在主线程执行
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onScrollEvent(ScrollEvent event){
        if (event.isUp()){
            if(pub_title_id.getVisibility() == View.GONE){
                return;
            }

            ObjectAnimator anim = ObjectAnimator.ofFloat(pub_title_id, "y", pub_title_id.getY(),
                    pub_title_id.getY() - pub_title_id.getHeight());
            anim.setDuration(500);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    pub_title_id.setVisibility(View.GONE);

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
            if(pub_title_id.getVisibility() == View.VISIBLE){
                return;
            }

            pub_title_id.setVisibility(View.VISIBLE);

            ObjectAnimator anim = ObjectAnimator.ofFloat(pub_title_id, "y", pub_title_id.getY(),
                    pub_title_id.getY() + pub_title_id.getHeight());
            anim.setDuration(500);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    pub_title_id.setVisibility(View.VISIBLE);

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

    @Override
    public void sussess(String string) {

    }

    @Override
    public void onFail() {

    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
