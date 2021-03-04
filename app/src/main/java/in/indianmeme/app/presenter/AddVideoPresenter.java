//package in.indianmeme.app.presenter;
//
//import in.indianmeme.app.ModelApi.AddImz.AddPicModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.AddVideoContract;
//import okhttp3.MultipartBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class AddVideoPresenter implements AddVideoContract.AddVideoInterecter {
//
//    private final AddVideoContract.AddVideoView addVideoView;
//
//    public AddVideoPresenter(AddVideoContract.AddVideoView addVideoView) {
//        this.addVideoView = addVideoView;
//    }
//
//    @Override
//    public void getData(MultipartBody.Part video, MultipartBody.Part server_key, MultipartBody.Part access_token, MultipartBody.Part caption, MultipartBody.Part thumb) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.addVideo(server_key, access_token, video, thumb, caption).enqueue(new Callback<AddPicModel>() {
//            @Override
//            public void onResponse(Call<AddPicModel> call, Response<AddPicModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    addVideoView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AddPicModel> call, Throwable t) {
//
//            }
//        });
//    }
//}
//
//
