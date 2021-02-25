package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.Delete.DeletePostModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.DeleteContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeletePresenter implements DeleteContract.DeleleInterecter {

    DeleteContract.DelteView delteView;

    public DeletePresenter(DeleteContract.DelteView delteView) {
        this.delteView = delteView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.deletePost(map).enqueue(new Callback<DeletePostModel>() {
            @Override
            public void onResponse(Call<DeletePostModel> call, Response<DeletePostModel> response) {
                int code = 200;
                if (response.code() == code) {
                    delteView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeletePostModel> call, Throwable t) {

            }
        });

    }
}
