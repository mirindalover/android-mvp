package com.mlc.mvp;

/**
 * Created by mulianchao on 2019/7/12.
 * <p>
 * 仅用于不使用lifecycle时--不关注生命周期，可继承MvpPresenter来写presenter
 */

public class MvpPresenter<V extends IMvpView> implements IMvpPresenter<V> {

    protected V mView;

    @Override
    public void onBind(V view) {
        mView = view;
    }

    @Override
    public void onViewAttach() {

    }

    @Override
    public void onViewDetach() {
        mView = null;
    }
}
