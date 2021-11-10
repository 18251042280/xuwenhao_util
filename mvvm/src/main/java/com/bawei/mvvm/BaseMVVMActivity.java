package com.bawei.mvvm;


import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Android Studio.
 * User: 小徐
 * Date: 2021/11/9
 * Time: 18:42
 */
public abstract class BaseMVVMActivity<VM extends BaseViewModel,Binding extends ViewDataBinding> extends BaseActivity {
    protected Binding binding;
    protected VM vm;

    private HashMap<Integer,Object> hashMap = new HashMap<>();

    @Override
    protected void initEnv() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        binding.setLifecycleOwner(this);
        vm = createViewModel();

        preSet(hashMap);
        setVar(binding,hashMap);
    }
    protected abstract void preSet(HashMap<Integer,Object> hashMap);
    protected void setVar(Binding binding,HashMap<Integer,Object> hashMap){
        for (Map.Entry<Integer,Object> integerObjectEntry : hashMap.entrySet()){
            binding.setVariable(integerObjectEntry.getKey(),integerObjectEntry.getValue());
        }
    }
    protected abstract VM createViewModel();
    protected abstract int getLayoutId();

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}