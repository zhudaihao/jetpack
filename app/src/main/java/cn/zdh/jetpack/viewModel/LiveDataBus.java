package cn.zdh.jetpack.viewModel;

import java.util.HashMap;
import java.util.Map;

import androidx.lifecycle.MutableLiveData;

public class LiveDataBus {
    private Map<String,Object> map;

    private static final LiveDataBus liveDataBus = new LiveDataBus();

    private LiveDataBus() {
        map=new HashMap<>();
    }


    public static final LiveDataBus getInstance() {
        return liveDataBus;
    }


    public synchronized<T> MutableLiveData<T> with(String key,Class<T> t){
        //判断map是否包含传进来的key
        if (!map.containsKey(key)){
            map.put(key,new MutableLiveData<T>());
        }

        return (MutableLiveData<T>) map.get(key);


    }


}
