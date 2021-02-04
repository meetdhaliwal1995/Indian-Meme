package in.indianmeme.app.presenter;

import java.io.IOException;
import java.util.Map;

import in.indianmeme.app.ModelApi.Login.LoginModel;
import in.indianmeme.app.ModelApi.LoginError.ErrorLoginModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.UserLoginContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements UserLoginContract.LoginInteractor {

    private UserLoginContract.LoginView loginView;

    public LoginPresenter(UserLoginContract.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void getData(Map<String, Object> map) {

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userLogin(map).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                int code = 200;
                if (response.code() == code) {
                    loginView.setLatestData(response.body());
                } else {
                    try {
                        String error = response.errorBody().string();
                        ErrorLoginModel errorLoginModel = MyApp.getGson().fromJson(error, ErrorLoginModel.class);
                        loginView.showError(errorLoginModel.getErrors().getErrorText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });

    }
}
