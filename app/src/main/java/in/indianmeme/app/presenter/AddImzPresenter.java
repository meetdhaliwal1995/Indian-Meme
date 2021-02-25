package in.indianmeme.app.presenter;

import in.indianmeme.app.ModelApi.AddImz.AddPicModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.AddImzContract;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddImzPresenter implements AddImzContract.AddImzInterecter {

    private final AddImzContract.AddImzView addImzView;

    public AddImzPresenter(AddImzContract.AddImzView addImzView) {
        this.addImzView = addImzView;
    }

    @Override
    public void getData(MultipartBody.Part images, MultipartBody.Part server_key, MultipartBody.Part access_token, MultipartBody.Part caption) {

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addImz(server_key, access_token, images, caption).enqueue(new Callback<AddPicModel>() {
            @Override
            public void onResponse(Call<AddPicModel> call, Response<AddPicModel> response) {
                int code = 200;
                if (response.code() == code) {
                    addImzView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddPicModel> call, Throwable t) {

            }
        });
    }

}


