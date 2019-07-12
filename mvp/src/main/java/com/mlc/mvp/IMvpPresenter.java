package com.mlc.mvp;

/**
 * Created by mulianchao on 2019/7/12.
 */
public interface IMvpPresenter<V extends IMvpView> {

    /**
     * 初始化Presenter时,用于presenter与view绑定
     */
    void onBind(V view);

    void onViewAttach();

    void onViewDetach();

}
