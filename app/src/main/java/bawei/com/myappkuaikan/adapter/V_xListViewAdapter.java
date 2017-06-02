package bawei.com.myappkuaikan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.bean.GcBean;


/**
 * Created by Administrator on 2017/3/28.
 */

public class V_xListViewAdapter extends BaseAdapter{
    private final Context context;
    private final List<GcBean.DataBean.FeedsBean> list;

    public V_xListViewAdapter(Context context, List<GcBean.DataBean.FeedsBean> list) {
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
        MyHolder holder ;
        if (view == null){
            view = View.inflate(context, R.layout.v_xlsit_item,null);
            holder = new MyHolder();
            holder.image_tx = (ImageView) view.findViewById(R.id.image_tx);
            holder.image_gz = (ImageView) view.findViewById(R.id.image_gz);
            holder.image = (ImageView) view.findViewById(R.id.image);
            holder.v_image_zan = (ImageView) view.findViewById(R.id.v_image_zan);
            holder.v_image_pinglun = (ImageView) view.findViewById(R.id.v_image_pinglun);
            holder.text_name = (TextView) view.findViewById(R.id.text_name);
            holder.content = (TextView) view.findViewById(R.id.content);
            holder.time = (TextView) view.findViewById(R.id.time);
            holder.v_zan_count = (TextView) view.findViewById(R.id.v_zan_count);
            holder.v_pl_count = (TextView) view.findViewById(R.id.v_pl_count);

            view.setTag(holder);
        }else {
            holder = (MyHolder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(i).getUser().getAvatar_url(),holder.image_tx,
                new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.ic_launcher).build());
        holder.text_name.setText(list.get(i).getUser().getNickname());
        holder.image_gz.setImageResource(R.mipmap.ic_subscribe_button_normal);
        holder.content.setText(list.get(i).getContent().getText());
        holder.image.setImageResource(R.mipmap.ic_common_placeholder_l);
        //holder.time.setText();
        holder.v_zan_count.setText(list.get(i).getLikes_count()+"");
        holder.v_pl_count.setText(list.get(i).getComments_count()+"");

        return view;
    }
    class MyHolder{
        ImageView image_tx,image_gz,image,v_image_zan,v_image_pinglun;
        TextView text_name,content,time,v_zan_count,v_pl_count;
    }
}
