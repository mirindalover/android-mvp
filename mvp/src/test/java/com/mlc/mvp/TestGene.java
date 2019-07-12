package com.mlc.mvp;

public class TestGene {

    interface IView extends IMvpView {
        void doView();
    }

    interface IPresenter extends IMvpPresenter<IView> {
        void doPresenter();
    }

    public static class Presenter implements IPresenter {

        @Override
        public void doPresenter() {

        }

        IView mView;

        @Override
        public void onBind(IView view) {
            mView = view;
        }

        @Override
        public void onViewAttach() {

        }

        @Override
        public void onViewDetach() {

        }
    }

    public static class View implements IView {

        public View() {
            IPresenter presenter1 = Helper.fixPresenter(this, new Presenter());
            IPresenter presenter2 = Helper.from(this, new Presenter());
        }

        @Override
        public void doView() {

        }
    }

    public static class Helper {

        /**
         * 大多数问题可以通过引入一个第三方(类、变量)来解决
         */
        public static <V extends IMvpView, P extends IMvpPresenter<V>, T extends V> P fixPresenter(T view, P presenter) {
            presenter.onBind(view);
            return presenter;
        }

        /**
         * 使用通配符
         */
        public static <V extends IMvpView, P extends IMvpPresenter<? super V>> P from(V view, P presenter) {
            presenter.onBind(view);
            return presenter;
        }
    }
}
