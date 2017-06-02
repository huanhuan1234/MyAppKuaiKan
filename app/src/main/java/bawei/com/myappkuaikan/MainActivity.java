package bawei.com.myappkuaikan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.base.BaseActivity;
import bawei.com.myappkuaikan.fragment.FeedFragment;
import bawei.com.myappkuaikan.fragment.FindFragment;
import bawei.com.myappkuaikan.fragment.HomeFragment;
import bawei.com.myappkuaikan.fragment.MeFragment;
import bawei.com.myappkuaikan.listener.ViewListener;

public class MainActivity extends BaseActivity  implements ViewListener{
private List<Fragment> list=new ArrayList<Fragment>();
    private RadioGroup radiogroup;
    private RadioButton radioButtonHome;
    private RadioButton radioButtonFind;
    private RadioButton radioButtonFeed;
    private RadioButton radioButtonMe;
    private int selectIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        creatFragment();
        showFragment(0);
    }



    //初始化ui
    @Override
    public void init() {

        radiogroup = (RadioGroup) findViewById(R.id.tab_radiogroup);
        radioButtonHome = (RadioButton) findViewById(R.id.tab_radiobutton_home);
        radioButtonFind = (RadioButton) findViewById(R.id.tab_radiobutton_find);
        radioButtonFeed = (RadioButton) findViewById(R.id.tab_radiobutton_feed);
        radioButtonMe = (RadioButton) findViewById(R.id.tab_radiobutton_me);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.tab_radiobutton_home:
                        selectIndex=0;
                        break;
                    case R.id.tab_radiobutton_find:
                        selectIndex=1;
                        break;
                    case R.id.tab_radiobutton_feed:
                        selectIndex=2;
                        break;
                    case R.id.tab_radiobutton_me:
                        selectIndex=3;
                        break;
                }
                showFragment(selectIndex);
            }
        });

    }

    //创建fragment
    private void creatFragment() {

        HomeFragment homeFragment = new HomeFragment();
        FindFragment findFragment = new FindFragment();
        FeedFragment feedFragment = new FeedFragment();
        MeFragment meFragment = new MeFragment();

        list.add(homeFragment);
        list.add(findFragment);
        list.add(feedFragment);
        list.add(meFragment);
    }

    private void showFragment(int position){
        //得到fragment的管理者
        FragmentManager fragmentManager = getSupportFragmentManager();
        //得到管理者事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!list.get(position).isAdded()){
            transaction.add(R.id.container,list.get(position));
        }
        for (int i = 0; i <list.size() ; i++) {
            if (position==i){
                transaction.show(list.get(i));
            }else {
                transaction.hide(list.get(i));
            }
        }
        transaction.commit();
    }
}
