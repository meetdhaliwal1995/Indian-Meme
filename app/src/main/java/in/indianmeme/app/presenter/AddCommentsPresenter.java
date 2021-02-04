package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddComments.AddComment;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.AddCommentContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCommentsPresenter implements AddCommentContract.AddCommentInterector {

    private AddCommentContract.AddCommentView addCommentView;

    public AddCommentsPresenter(AddCommentContract.AddCommentView addCommentView) {
        this.addCommentView = addCommentView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addComment(map).enqueue(new Callback<AddComment>() {
            @Override
            public void onResponse(Call<AddComment> call, Response<AddComment> response) {
                int code = 200;
                if (response.code() == code) {
                    addCommentView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddComment> call, Throwable t) {

            }
        });

    }
}
