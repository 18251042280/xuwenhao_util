package com.bawei.mvvm;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

/**
 * Created by Android Studio.
 * User: 小徐
 * Date: 2021/11/9
 * Time: 18:31
 */
public abstract class BaseViewModel<Repo extends BaseRepository> extends ViewModel implements LifecycleObserver {
    protected Repo mRepository;
    private LifecycleOwner owner;

    public BaseViewModel(LifecycleOwner owner) {
        this.mRepository = createRepository();
        this.owner = owner;
        owner.getLifecycle().addObserver(this);
    }

    protected abstract Repo createRepository();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void uiConnect(){
        initResource();
    }

    protected abstract void initResource();
    protected void releaseResource() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnect(){
        releaseResource();
        owner.getLifecycle().removeObserver(this);
    }
}