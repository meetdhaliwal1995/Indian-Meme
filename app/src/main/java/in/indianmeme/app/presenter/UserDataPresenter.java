//package in.indianmeme.app.presenter;
//
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.UserData.UserDataModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.UserDataContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class UserDataPresenter implements UserDataContract.UserInterecter {
//
//    private final UserDataContract.UserView userView;
//
//    public UserDataPresenter(UserDataContract.UserView userView) {
//
//        this.userView = userView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.userData(map).enqueue(new Callback<UserDataModel>() {
//            @Override
//            public void onResponse(Call<UserDataModel> call, Response<UserDataModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    userView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserDataModel> call, Throwable t) {
//
//            }
//        });
//
//    }
//}
//
