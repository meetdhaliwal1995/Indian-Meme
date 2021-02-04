package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.ProfileModel.UserProfile;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.UserProfileContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfilePresenter implements UserProfileContract.UserProfileInteractor {

    private UserProfileContract.UserProfileView userProfileView;

    public UserProfilePresenter(UserProfileContract.UserProfileView userProfileView) {
        this.userProfileView = userProfileView;
    }


    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userProfile(map).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                int code = 200;
                if (code == response.code()) {
                    userProfileView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }
}
