package bawei.com.myappkuaikan.fragment.second;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.com.LoginActivity;

/**
 * Created by huanhuan on 2017/4/26.
 */

public class FocusFragment extends Fragment {

    private ImageView gz_dl;
    private SharedPreferences sp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.focus_fragment,null);

        gz_dl = (ImageView) view.findViewById(R.id.gz_dl);

        setLinstener();

        return view;
    }

    private void setLinstener() {
        gz_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
