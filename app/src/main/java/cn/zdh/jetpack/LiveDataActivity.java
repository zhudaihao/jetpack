package cn.zdh.jetpack;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import cn.zdh.jetpack.viewModel.LiveDataBus;
import cn.zdh.jetpack.viewModel.MyViewModel;

public class LiveDataActivity extends AppCompatActivity {


    private MutableLiveData<List<Bean>> liveData;
    private List<Bean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);



        /**
         * 正常使用liveData
         */
        //调用系统API获取 viewModel
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        liveData = myViewModel.getLiveData();
        //订阅消息
        liveData.observe(this, new Observer<List<Bean>>() {
            @Override
            public void onChanged(List<Bean> beans) {
                //数据接收
                Toast.makeText(LiveDataActivity.this, "" + beans.get(0).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        /**
         * 使用封装的liveData
         */
        LiveDataBus.getInstance().with("1", Bean.class).observe(this, new Observer<Bean>() {
            @Override
            public void onChanged(Bean bean) {
                Toast.makeText(LiveDataActivity.this, "" + bean.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    /**
     * 正常使用liveData 发送数据
     */
    public void load(View view) {
        //添加数据到liveData仓库(发送消息)
        list.add(new Bean("张三"));
        list.add(new Bean("李四"));
        liveData.setValue(list);
    }


    /**
     * 使用封装的liveData 发送数据
     */
    public void send(View view) {
        Bean bean = new Bean("测试");
        LiveDataBus.getInstance().with("1", Bean.class).setValue(bean);

    }


}
