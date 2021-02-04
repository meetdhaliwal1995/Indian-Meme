package in.indianmeme.app.presenter;

import java.io.IOException;
import java.util.Map;

import in.indianmeme.app.ModelApi.error.ErrorModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.UserRegisterContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUserPresenter implements UserRegisterContract.UserInterector {

    private UserRegisterContract.UserView userView;


    public RegisterUserPresenter(UserRegisterContract.UserView userView) {
        this.userView = userView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);


        networkInterface.registerUser(map).enqueue(new Callback<in.indianmeme.app.ModelApi.UserRegisterModel.UserRegister>() {
            @Override
            public void onResponse(Call<in.indianmeme.app.ModelApi.UserRegisterModel.UserRegister> call, Response<in.indianmeme.app.ModelApi.UserRegisterModel.UserRegister> response) {
                int code = 200;
                if (response.code() == code) {
                    userView.setLatestData(response.body());
                } else {
                    try {
                        String err = response.errorBody().string();
                        ErrorModel errorModel = MyApp.getGson().fromJson(err, ErrorModel.class);
                        userView.showError(errorModel.getErrors().getErrorText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<in.indianmeme.app.ModelApi.UserRegisterModel.UserRegister> call, Throwable t) {

            }
        });
    }
}
