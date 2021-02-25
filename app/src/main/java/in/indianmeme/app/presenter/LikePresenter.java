package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddLike.LikesUnlikeModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.LikeContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LikePresenter implements LikeContract.LikeInterecter {

    private final LikeContract.LikeView likeView;

    public LikePresenter(LikeContract.LikeView likeView) {
        this.likeView = likeView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface ne = MyApp.getRetrofit().create(NetworkInterface.class);
        ne.addLike(map).enqueue(new Callback<LikesUnlikeModel>() {
            @Override
            public void onResponse(Call<LikesUnlikeModel> call, Response<LikesUnlikeModel> response) {
                int code = 200;
                if (response.code() == code) {
                    likeView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<LikesUnlikeModel> call, Throwable t) {

            }
        });

    }
}

