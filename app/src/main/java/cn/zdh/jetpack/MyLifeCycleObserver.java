package cn.zdh.jetpack;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 感知生命周期
 */
public class MyLifeCycleObserver implements LifecycleObserver {

    /**
     * 使用注解 onLifecycleEvent 参数是对应感知的生命周期
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onstart() {
        Log.e("zdh", "---------------activity开始的生命周期");

    }

}
