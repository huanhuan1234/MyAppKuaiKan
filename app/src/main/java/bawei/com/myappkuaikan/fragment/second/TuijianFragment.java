package bawei.com.myappkuaikan.fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.task.ResponesListener;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class TuijianFragment extends Fragment implements ResponesListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian_fragment, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
    }

    @Override
    public void sussess(String string) {

    }

    @Override
    public void onFail() {

    }
}
