package com.mlc.mvp;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by mulianchao on 2019/7/12.
 * <p>
 * 仅用于不使用lifecycle时--不关注生命周期，可继承MvpPresenter来写presenter
 */

public abstract class MvpPresenter<V extends IMvpView> implements IMvpPresenter<V> {

    private V mView;

    protected Context mContext;

    @Override
    public void onBind(V view) {
        mView = view;
        if (view instanceof Fragment) {
            mContext = ((Fragment) view).getContext();
        } else if (view instanceof Activity) {
            mContext = (Activity) view;
        } else if (view instanceof View) {
            mContext = ((View) view).getContext();
        }
    }

    @Override
    public void onViewAttach() {

    }

    @Override
    public void onViewDetach() {
        mView = null;
    }

    protected V getView() {
        if (mView == null) {
            return createDummyView();
        }
        return mView;
    }

    protected abstract V createDummyView();
}
