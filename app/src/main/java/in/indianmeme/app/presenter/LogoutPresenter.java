package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.Logout.LogoutUserModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.LogoutContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutPresenter implements LogoutContract.LogoutInterecter {

    LogoutContract.LogoutView logoutView;

    public LogoutPresenter(LogoutContract.LogoutView logoutView) {
        this.logoutView = logoutView;
    }


    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.logoutUser(map).enqueue(new Callback<LogoutUserModel>() {
            @Override
            public void onResponse(Call<LogoutUserModel> call, Response<LogoutUserModel> response) {
                int code = 200;
                if (response.code() == code) {
                    logoutView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<LogoutUserModel> call, Throwable t) {

            }
        });

    }
}
