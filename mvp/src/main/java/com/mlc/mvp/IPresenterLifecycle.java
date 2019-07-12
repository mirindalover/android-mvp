package com.mlc.mvp;

/**
 * Created by mulianchao on 2019/7/12.
 */
public interface IPresenterLifecycle<V extends IMvpView> extends IMvpPresenter<V> {

    void onStart();

    void onResume();

    void onStop();


}
