package in.indianmeme.app.views;

import java.util.Map;

public interface UserRegisterContract {

    interface UserView {

        void showProgress();

        void hideProgress();


        void setLatestData(in.indianmeme.app.ModelApi.UserRegisterModel.UserRegister userRegister);

        void showError(String error);
    }

    interface UserInterector {

        void getData(Map<String, Object> map);
    }
}

