//package in.indianmeme.app.presenter;
//
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.Comments.CommentInfoModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.UserCommentContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class CommentsPresenter implements UserCommentContract.UserCommentInterector {
//
//
//    private final UserCommentContract.UserCommentView userCommentView;
//
//    public CommentsPresenter(UserCommentContract.UserCommentView userCommentView) {
//        this.userCommentView = userCommentView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.getComments(map).enqueue(new Callback<CommentInfoModel>() {
//            @Override
//            public void onResponse(Call<CommentInfoModel> call, Response<CommentInfoModel> response) {
//                int code = 200;
//                if (code == response.code()) {
//                    userCommentView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CommentInfoModel> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//
//}
