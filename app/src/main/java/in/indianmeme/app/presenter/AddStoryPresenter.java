package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddStory.AddStoryUser;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.AddStroyContract;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStoryPresenter implements AddStroyContract.AddStoryInterecter {

    private AddStroyContract.AddStoryView addStoryView;

    public AddStoryPresenter(AddStroyContract.AddStoryView addStoryView) {
        this.addStoryView = addStoryView;
    }

    @Override
    public void getData(MultipartBody.Part file, MultipartBody.Part server_key, MultipartBody.Part access_token) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addStroy(server_key, access_token, file).enqueue(new Callback<AddStoryUser>() {
            @Override
            public void onResponse(Call<AddStoryUser> call, Response<AddStoryUser> response) {
                int code = 200;
                if (response.code() == code) {
                    addStoryView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddStoryUser> call, Throwable t) {

            }
        });
    }

}


