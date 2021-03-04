//package in.indianmeme.app.presenter;
//
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.AddUserReply.AddReplyModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.AddRplyContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class UserAddRplyPresenter implements AddRplyContract.AddRplyInterecter {
//
//    private final AddRplyContract.AddRplyView addRplyView;
//
//    public UserAddRplyPresenter(AddRplyContract.AddRplyView addRplyView) {
//        this.addRplyView = addRplyView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.userRplyAdd(map).enqueue(new Callback<AddReplyModel>() {
//            @Override
//            public void onResponse(Call<AddReplyModel> call, Response<AddReplyModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    addRplyView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AddReplyModel> call, Throwable t) {
//
//            }
//        });
//
//    }
//}
