//package in.indianmeme.app.presenter;
//
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.Follow.FollowUserModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.FollowContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class FollowPresenter implements FollowContract.FollowInterecter {
//
//    private final FollowContract.FollowView followView;
//
//    public FollowPresenter(FollowContract.FollowView followView) {
//        this.followView = followView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.userFollow(map).enqueue(new Callback<FollowUserModel>() {
//            @Override
//            public void onResponse(Call<FollowUserModel> call, Response<FollowUserModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    followView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<FollowUserModel> call, Throwable t) {
//
//            }
//        });
//
//    }
//}
//
