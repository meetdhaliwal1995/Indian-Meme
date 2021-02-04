package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.ExplorePosts.PostExplore;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.PostHomeExploreContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostHomeExplorerPresenter implements PostHomeExploreContract.ExploreInterector {

    private PostHomeExploreContract.ExploreView exploreView;

    public PostHomeExplorerPresenter(PostHomeExploreContract.ExploreView exploreView) {
        this.exploreView = exploreView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.postExplore(map).enqueue(new Callback<PostExplore>() {
            @Override
            public void onResponse(Call<PostExplore> call, Response<PostExplore> response) {
                int code = 200;
                if (response.code() == code) {
                    exploreView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<PostExplore> call, Throwable t) {

            }
        });
    }
}
