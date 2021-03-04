//package in.indianmeme.app.presenter;
//
//import java.io.IOException;
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.UserRegisterModel.UserRegisterModel;
//import in.indianmeme.app.ModelApi.error.ErrorModelModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.UserRegisterContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class RegisterUserPresenter implements UserRegisterContract.UserInterector {
//
//    private final UserRegisterContract.UserView userView;
//
//
//    public RegisterUserPresenter(UserRegisterContract.UserView userView) {
//        this.userView = userView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//
//
//        networkInterface.registerUser(map).enqueue(new Callback<UserRegisterModel>() {
//            @Override
//            public void onResponse(Call<UserRegisterModel> call, Response<UserRegisterModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    userView.setLatestData(response.body());
//                } else {
//                    try {
//                        String err = response.errorBody().string();
//                        ErrorModelModel errorModel = MyApp.getGson().fromJson(err, ErrorModelModel.class);
//                        userView.showError(errorModel.getErrors().getErrorText());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserRegisterModel> call, Throwable t) {
//
//            }
//        });
//    }
//}
