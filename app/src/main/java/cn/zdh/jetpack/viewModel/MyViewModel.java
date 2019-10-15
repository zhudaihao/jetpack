package cn.zdh.jetpack.viewModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cn.zdh.jetpack.Bean;


/**
 * liveData是个抽象类 ，可以理解为一个能感知生命周期的仓库
 * mutableLIveData 是他的实现类
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Bean>> mutableLiveData;

    //获取仓库
    public MutableLiveData<List<Bean>> getLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }


}
