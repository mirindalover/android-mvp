package com.mlc.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by mulianchao on 2019/7/12.
 * <p>
 * 具有生命周期的Presenter
 */

public abstract class PresenterLifecycle<V extends IMvpView> extends MvpPresenter<V> implements LifecycleObserver, IPresenterLifecycle<V> {

    private final BehaviorSubject<Lifecycle.Event> mLifecycleSubject = BehaviorSubject.create();

    @Override
    public void onBind(V view) {
        super.onBind(view);
        if (view instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) view).getLifecycle();
            //会立马调用对应的监听
            lifecycle.addObserver(this);
            if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                this.onViewAttach();
            }
        }
    }

    public <T> LifecycleTransformer<T> bindUntilEvent(Lifecycle.Event event) {
        return MvpLifecycleHelper.bindUntilEvent(mLifecycleSubject, event);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onViewAttach() {
        mLifecycleSubject.onNext(Lifecycle.Event.ON_CREATE);
    }


    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        mLifecycleSubject.onNext(Lifecycle.Event.ON_START);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        mLifecycleSubject.onNext(Lifecycle.Event.ON_RESUME);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        mLifecycleSubject.onNext(Lifecycle.Event.ON_STOP);
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onViewDetach() {
        mLifecycleSubject.onNext(Lifecycle.Event.ON_DESTROY);
        super.onViewDetach();
    }
}
