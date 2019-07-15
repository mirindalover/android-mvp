/*
 *
 *  * Copyright (C) 2018 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.mlc.androidmvp.main;

import com.mlc.mvp.PresenterLifecycle;

import java.util.List;

class MainPresenter extends PresenterLifecycle<MainView> {

    private FindItemsModel findItemsModel = new FindItemsModel();


    public void onResume() {
        if (getView() != null) {
            getView().showProgress();
        }

        findItemsModel.findItems(this::onFinished);
    }

    void onItemClicked(String item) {
        if (getView() != null) {
            getView().showMessage(String.format("%s clicked", item));
        }
    }

    public void onFinished(List<String> items) {
        if (getView() != null) {
            getView().setItems(items);
            getView().hideProgress();
        }
    }

    @Override
    protected MainView createDummyView() {
        return new MainView() {
            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void setItems(List<String> items) {

            }

            @Override
            public void showMessage(String message) {

            }
        };
    }
}
