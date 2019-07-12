package com.mlc.mvp;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * Created by mulianchao on 2019/7/12.
 * <p>
 * 上游添加takeUntil函数
 * <p>
 * mObservableSource有输出后整个过程停止
 */
public class LifecycleTransformer<Stream> implements ObservableTransformer<Stream, Stream> {

    private final ObservableSource<?> mObservableSource;

    public LifecycleTransformer(ObservableSource<?> mObservableSource) {
        this.mObservableSource = mObservableSource;
    }

    @Override
    public ObservableSource<Stream> apply(Observable<Stream> upstream) {
        return upstream.takeUntil(mObservableSource);
    }
}
