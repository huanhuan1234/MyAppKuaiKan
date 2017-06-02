package bawei.com.myappkuaikan.fragment.thrid;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.bean.FenLeiBean;
import bawei.com.myappkuaikan.task.IAsyncTak;
import bawei.com.myappkuaikan.task.ResponesListener;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class FenLeiFragmentTitile extends Fragment implements SwipeRefreshLayout.OnRefreshListener,ResponesListener{

    private SwipeRefreshLayout swiperefershlayout;
    private ListView listView;
    private String fenlei;

    private List<FenLeiBean.DataBean.TopicsBean> list=new ArrayList<FenLeiBean.DataBean.TopicsBean>();
    private FenLeiAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fenlei_fragment_listview,container,false);

        if (getArguments()!=null){
            fenlei = getArguments().getString("fenlei");
        }
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    private void initView(View view) {
        swiperefershlayout = (SwipeRefreshLayout) view.findViewById(R.id.fenlei_swiperefershlayout);
        listView = (ListView) view.findViewById(R.id.fenlei_listview);
        adapter = new FenLeiAdapter();
        listView.setAdapter(adapter);


    }

    private void getData(){
        String path="http://api.kuaikanmanhua.com/v1/topic_new/lists/get_by_tag?tag=0&since=0&count=20&gender=1&sort=1&sa_event=eyJkaXN0aW5jdF9pZCI6IkE6NjE0ODI3NzVmNTZkNWY4MiIsImV2ZW50IjoiUmVhZEZpbmRQYWdlIiwib3JpZ2luYWxfaWQiOiJBOjYxNDgyNzc1ZjU2ZDVmODIiLCJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJwcm9wZXJ0aWVzIjp7IkNhdGVnb3J5Ijoi5YWo6YOoIiwiRmluZENhdGVnb3J5VGFiTmFtZSI6IuWFqOmDqCIsIkZpbmRUYWJOYW1lIjoi5YiG57G7IiwiRnJvbUZpbmRDYXRlZ29yeVRhYk5hbWUiOiLlhajpg6giLCJGcm9tRmluZFRhYk5hbWUiOiLmjqjojZAiLCJHZW5kZXJUeXBlIjoi55S354mIIiwiSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiSG9tZXBhZ2VVcGRhdGVEYXRlIjoxLCJJc0F1dG9Mb2FkIjpmYWxzZSwiVHJpZ2dlclBhZ2UiOiJIb21lUGFnZSIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiUHJvcGVydHlFdmVudCI6IlJlYWRGaW5kUGFnZSIsImFidGVzdF9ncm91cCI6MTQsIiRhcHBfdmVyc2lvbiI6IjQuMC4wIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG1hbnVmYWN0dXJlciI6IkhVQVdFSSIsIiRtb2RlbCI6Ik5FTS1BTDEwIiwiJG9zIjoiQW5kcm9pZCIsIiRvc192ZXJzaW9uIjoiNi4wIiwiJHNjcmVlbl9oZWlnaHQiOjE4MTIsIiRzY3JlZW5fd2lkdGgiOjEwODAsIiR3aWZpIjp0cnVlLCIkY2FycmllciI6IuS4reWbveeUteS_oSIsIiRuZXR3b3JrX3R5cGUiOiJXSUZJIn0sInRpbWUiOjE0OTMyMDc3MTgzNDUsInR5cGUiOiJ0cmFjayJ9";
        new IAsyncTak(this).execute(path);
    }
    @Override
    public void sussess(String string) {
        swiperefershlayout.setRefreshing(false);
        Gson gson = new Gson();
        FenLeiBean fenLeiBean = gson.fromJson(string, FenLeiBean.class);
        list.addAll(fenLeiBean.getData().getTopics());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFail() {
        swiperefershlayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        getData();
    }
    class FenLeiAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null ;

            if( convertView == null ){


                convertView = View.inflate(getActivity(),R.layout.week_item,null);


                viewHolder = new ViewHolder();

                viewHolder.fenlei_fragment_listview_iv = (ImageView) convertView.findViewById(R.id.fenlei_fragment_listview_iv);

                viewHolder.fenlei_title = (TextView) convertView.findViewById(R.id.fenlei_title);

                viewHolder.fenlei_jieshao = (TextView) convertView.findViewById(R.id.fenlei_jieshao);

                viewHolder.fenlei_item_image_zan = (ImageView) convertView.findViewById(R.id.fenlei_item_image_zan);
                viewHolder.fenlei_item_zannum = (TextView) convertView.findViewById(R.id.fenlei_item_zannum);

                viewHolder.fenlei_item_image_comment = (ImageView) convertView.findViewById(R.id.fenlei_item_image_comment);
                viewHolder.fenlei_item_comment = (TextView) convertView.findViewById(R.id.fenlei_item_comment);

                convertView.setTag(viewHolder);

            } else {

                viewHolder = (ViewHolder) convertView.getTag() ;

            }

            ImageLoader.getInstance().displayImage(list.get(position).getCover_image_url(),viewHolder.fenlei_fragment_listview_iv);
            viewHolder.fenlei_title.setText(list.get(position).getTitle());
            viewHolder.fenlei_jieshao.setText(list.get(position).getUser().getNickname());

            viewHolder.fenlei_item_zannum.setText(list.get(position).getLikes_count()+"");
            viewHolder.fenlei_item_comment.setText(list.get(position).getComments_count()+"");

            viewHolder.fenlei_item_image_zan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // 点赞动画

                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(
                            ObjectAnimator.ofFloat(v, "scaleY", 1, 1.4f, 1),
                            ObjectAnimator.ofFloat(v, "scaleX", 1, 1.4f, 1));
                    animatorSet.setDuration(400);
                    animatorSet.start();
                }
            });

            return convertView;
        }
    }
    static class ViewHolder {

        ImageView fenlei_fragment_listview_iv;
        TextView fenlei_title;
        TextView fenlei_jieshao;


        //
        ImageView fenlei_item_image_zan;

        //
        TextView fenlei_item_zannum;

        ImageView fenlei_item_image_comment;
        TextView fenlei_item_comment;



    }
}
