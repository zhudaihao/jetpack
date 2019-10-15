package cn.zdh.jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 生命周期感知
     *
     * @param view
     */
    public void lifeCycle(View view) {
        startActivity(new Intent(this, LifeCycleActivity.class));
    }


    /**
     * 数据传输
     *
     * @param view
     */
    public void liveData(View view) {
        startActivity(new Intent(this, LiveDataActivity.class));
    }
}
