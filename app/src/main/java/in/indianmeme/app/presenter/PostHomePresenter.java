//package in.indianmeme.app.presenter;
//
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.HomePage.HomePageDataModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.PostHomeContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class PostHomePresenter implements PostHomeContract.HomePostInterector {
//
//    private PostHomeContract.PostHomeView homeView;
//
//    public PostHomePresenter(PostHomeContract.PostHomeView homeView) {
//        this.homeView = homeView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.homePage(map).enqueue(new Callback<HomePageDataModel>() {
//            @Override
//            public void onResponse(Call<HomePageDataModel> call, Response<HomePageDataModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    homeView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HomePageDataModel> call, Throwable t) {
//
//            }
//        });
//
//    }
//}
