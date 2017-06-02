package bawei.com.myappkuaikan.fragment.thrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.WeekFragmentAdapter;
import bawei.com.myappkuaikan.bean.Weekbean;
import bawei.com.myappkuaikan.event.ScrollEvent;
import bawei.com.myappkuaikan.task.IAsyncTak;
import bawei.com.myappkuaikan.task.ResponesListener;

/**
 * Created by huanhuan on 2017/4/26.
 */

public class WeekFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,ResponesListener{
    String week;
    private TextView textView;
    private ListView listView;
    private SwipeRefreshLayout swipeRefresh;
    private List<Weekbean.DataBean.ComicsBean> list=new ArrayList<Weekbean.DataBean.ComicsBean>();
    private WeekFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_fragmrnt, container, false);

        if (getArguments()!=null){
            week=getArguments().getString("week");
        }
        initView(view);

//        post.setHeader("Content-Type", "application/x-www-form-urlencoded");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    int index=0;

    private void initView(View view) {
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.week_swiperefershlayout);
        listView = (ListView) view.findViewById(R.id.week_listview);

        swipeRefresh.setOnRefreshListener(this);
        adapter = new WeekFragmentAdapter(this.getActivity(),list);
        listView.setAdapter(adapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    index=listView.getLastVisiblePosition();
                }
                if (scrollState==AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    if (listView.getLastVisiblePosition()-index>0){
                        EventBus.getDefault().post(new ScrollEvent(true));
                    }else {
                        EventBus.getDefault().post(new ScrollEvent(false));
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    //下拉刷新
    @Override
    public void onRefresh() {
        getData();
        EventBus.getDefault().post(new ScrollEvent(true));

    }
    // 发送网络请求
    private void getData(){
        String path = "http://api.kuaikanmanhua.com/v1/daily/comic_lists/"+week+"?since=0&gender=0&sa_event=eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg5NjQzNTYxODM4LCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjQuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6IkxFTk9WTyIsIkZyb21Ib21lcGFnZVVwZGF0ZURhdGUiOjMsIiRzY3JlZW5faGVpZ2h0IjoxNDQwLCJIb21lcGFnZVVwZGF0ZURhdGUiOjMsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6MTAsIiRzY3JlZW5fd2lkdGgiOjkwMCwiJG9zIjoiQW5kcm9pZCIsIlRyaWdnZXJQYWdlIjoiSG9tZVBhZ2UiLCIkY2FycmllciI6IkNISU5BIE1PQklMRSIsIiRtb2RlbCI6Ikxlbm92byBQNzAtdCIsIiRhcHBfdmVyc2lvbiI6IjMuOS4yIn0sInR5cGUiOiJ0cmFjayIsImRpc3RpbmN0X2lkIjoiQTo1MDdCOUQyN0Q2NUEwMDAwIiwib3JpZ2luYWxfaWQiOiJBOjUwN0I5RDI3RDY1QTAwMDAiLCJldmVudCI6IlJlYWRIb21lUGFnZSJ9" ;

        new IAsyncTak(this).execute(path);
    }
    //成功就请求回调
    @Override
    public void sussess(String string) {

        System.out.println("---info----" + string);
        swipeRefresh.setRefreshing(false);

        Gson gson = new Gson();
        Weekbean bean =  gson.fromJson(string, Weekbean.class);


        list.addAll(bean.getData().getComics());

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail() {
        swipeRefresh.setRefreshing(false);
    }

}
