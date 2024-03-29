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

package com.mlc.androidmvp.login;

import com.mlc.mvp.PresenterLifecycle;

public class LoginPresenter extends PresenterLifecycle<LoginView> implements LoginModel.OnLoginFinishedListener {

    private LoginModel loginModel = new LoginModel();

    public void validateCredentials(String username, String password) {
        if (getView() != null) {
            getView().showProgress();
        }

        loginModel.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        if (getView() != null) {
            getView().setUsernameError();
            getView().hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (getView() != null) {
            getView().setPasswordError();
            getView().hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (getView() != null) {
            getView().navigateToHome();
        }
    }

    @Override
    protected LoginView createDummyView() {
        return new LoginView() {
            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void setUsernameError() {

            }

            @Override
            public void setPasswordError() {

            }

            @Override
            public void navigateToHome() {

            }
        };
    }
}
