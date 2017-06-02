package bawei.com.myappkuaikan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.bean.UserBean;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class Me_Adapter extends BaseAdapter {

    private final Context context;
    private final List<UserBean> list;

    public Me_Adapter(Context context, List<UserBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = View.inflate(context, R.layout.list_me_item, null);


        ImageView image1 = (ImageView) view.findViewById(R.id.image1);
        TextView textView = (TextView) view.findViewById(R.id.text_me);
        ImageView image2 = (ImageView) view.findViewById(R.id.image2);

        image1.setImageResource(list.get(i).getImage());
        textView.setText(list.get(i).getMessage());
        image2.setImageResource(list.get(i).getImagejian());

        return view;
    }
}
