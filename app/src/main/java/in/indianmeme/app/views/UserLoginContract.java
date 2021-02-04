package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Login.LoginModel;

public interface UserLoginContract {

    interface LoginView {

        void showProgress();

        void hideProgress();

        void setLatestData(LoginModel loginModel);

        void showError(String error);
    }

    interface LoginInteractor {

        void getData(Map<String, Object> map);


    }
}
