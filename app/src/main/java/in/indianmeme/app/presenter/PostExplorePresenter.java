//package in.indianmeme.app.presenter;
//
//import java.util.Map;
//
//import in.indianmeme.app.ModelApi.ExplorePosts.PostExploreModel;
//import in.indianmeme.app.MyApp;
//import in.indianmeme.app.NetworkInterface;
//import in.indianmeme.app.views.PostExploreContract;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class PostExplorePresenter implements PostExploreContract.HomeExploreInterector {
//
//    private final PostExploreContract.PostExplorePostView exploreView;
//
//    public PostExplorePresenter(PostExploreContract.PostExplorePostView exploreView) {
//        this.exploreView = exploreView;
//    }
//
//    @Override
//    public void getData(Map<String, Object> map) {
//        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
//        networkInterface.postExplore(map).enqueue(new Callback<PostExploreModel>() {
//            @Override
//            public void onResponse(Call<PostExploreModel> call, Response<PostExploreModel> response) {
//                int code = 200;
//                if (response.code() == code) {
//                    exploreView.setLatestData(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PostExploreModel> call, Throwable t) {
//
//            }
//        });
//    }
//}
