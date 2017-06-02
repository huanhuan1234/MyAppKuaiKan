package bawei.com.myappkuaikan.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.Me_Adapter;
import bawei.com.myappkuaikan.bean.UserBean;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class MeFragment extends Fragment {
    private View view;
    private ImageView image_login;
    private ListView listView;
    private List<UserBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.me_fragment,null);

        initView();

        initData();

        listView.setAdapter(new Me_Adapter(getActivity(),list));
        setpicListener();


        return view;
    }

    private void setpicListener() {
        image_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                final AlertDialog alertDialog = dialog.create();

                View v = View.inflate(getActivity(),R.layout.alertdialog_layout,null);
                alertDialog.setView(v);
                alertDialog.show();
                TextView textView = (TextView) v.findViewById(R.id.paizhao);
                TextView textView2 = (TextView) v.findViewById(R.id.zhaopian);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1=new Intent();
                        intent1.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent1,1);
                        alertDialog.dismiss();
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent2=new Intent();
                        intent2.setAction(intent2.ACTION_PICK);
                        intent2.setType("image/*");
                        startActivityForResult(intent2,2);
                        alertDialog.dismiss();
                    }

                });
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            //得到照片
            Bitmap bitmap=data.getParcelableExtra("data");

            image_login.setImageBitmap(bitmap);
        }
        if(requestCode==2){
            //得到像册中图片的地址
            Uri uri=data.getData();
            //image_login.setImageURI(uri);
            crop(uri);
        }else if(requestCode==9999){
            //得到裁剪后的照片
            Bitmap bimap=data.getParcelableExtra("data");
            image_login.setImageBitmap(bimap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //是否裁剪
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", false);// 取消人脸识别

        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 9999);
    }

    private void initData() {
        list = new ArrayList<UserBean>();

        int[] image = {R.mipmap.xiaoxi,R.mipmap.ic_me_item_follow,R.mipmap.ic_me_item_collection,
                R.mipmap.ic_me_item_follow,R.mipmap.shangcheng,R.mipmap.dingdan,R.mipmap.ic_topic_history,R.mipmap.ic_me_item_collection,
                R.mipmap.shezhi};
        String[] str = {"我的消息","我的关注","我的收藏","快看游戏","快看商城","我的订单","浏览历史","智能缓存","设置"};

        for (int i = 0; i <str.length ; i++) {
            UserBean user = new UserBean();
            if (i==7){
                user.setImage(image[i]);
                user.setMessage(str[i]);
                user.setImagejian(R.mipmap.ic_cache_progressbar_pausing);
            }else{
                user.setImage(image[i]);
                user.setMessage(str[i]);
                user.setImagejian(R.mipmap.jian);
            }
            list.add(user);
        }
    }

    private void initView() {
        image_login = (ImageView) view.findViewById(R.id.image_login);
        listView = (ListView) view.findViewById(R.id.list_view_me);
    }
}
