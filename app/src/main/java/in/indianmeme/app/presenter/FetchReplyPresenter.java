package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.CommentsRply.FetchReplyModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.FetchReplyContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchReplyPresenter implements FetchReplyContract.AddRplyInterecter {


    private final FetchReplyContract.AddRplyView addRplyView;

    public FetchReplyPresenter(FetchReplyContract.AddRplyView addRplyView) {
        this.addRplyView = addRplyView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.replyFetch(map).enqueue(new Callback<FetchReplyModel>() {
            @Override
            public void onResponse(Call<FetchReplyModel> call, Response<FetchReplyModel> response) {
                int code = 200;
                if (response.code() == 200) {
                    addRplyView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<FetchReplyModel> call, Throwable t) {

            }
        });


    }
}

