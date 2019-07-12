package com.mlc.mvp;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

/**
 * Created by mulianchao on 2019/7/12.
 */
public class MvpLifecycleHelper {

    /**
     * 把View和Presenter关联起来
     */
    public static <V extends IMvpView, P extends IMvpPresenter<? super V>> P from(V view, P presenter) {
        presenter.onBind(view);
        return presenter;
    }


    public static <T, R> LifecycleTransformer<T> bindUntilEvent(final Observable<R> lifecycle, final R event) {
        return new LifecycleTransformer<>(lifecycle.filter(new Predicate<R>() {
            @Override
            public boolean test(R lifecycleEvent) throws Exception {
                return lifecycleEvent.equals(event);
            }
        }));
    }
}
