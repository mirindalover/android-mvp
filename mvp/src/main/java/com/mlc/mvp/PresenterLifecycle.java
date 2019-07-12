package com.mlc.mvp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by mulianchao on 2019/7/12.
 * <p>
 * 具有生命周期的Presenter
 */

public class PresenterLifecycle<V extends IMvpView> extends MvpPresenter<V> implements LifecycleObserver, IPresenterLifecycle<V> {

    private final BehaviorSubject<Lifecycle.Event> mLifecycleSubject = BehaviorSubject.create();

    @Override
    public void onBind(V view) {
        super.onBind(view);
        if (view instanceof LifecycleOwner) {
            ((LifecycleOwner) view).getLifecycle().addObserver(this);
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
