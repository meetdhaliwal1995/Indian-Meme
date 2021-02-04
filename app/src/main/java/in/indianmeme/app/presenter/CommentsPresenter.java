package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.Comments.CommentInfo;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.UserCommentContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsPresenter implements UserCommentContract.UserCommentInterector {


    private UserCommentContract.UserCommentView userCommentView;

    public CommentsPresenter(UserCommentContract.UserCommentView userCommentView) {
        this.userCommentView = userCommentView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getComments(map).enqueue(new Callback<CommentInfo>() {
            @Override
            public void onResponse(Call<CommentInfo> call, Response<CommentInfo> response) {
                int code = 200;
                if (code == response.code()) {
                    userCommentView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<CommentInfo> call, Throwable t) {

            }
        });

    }
}
