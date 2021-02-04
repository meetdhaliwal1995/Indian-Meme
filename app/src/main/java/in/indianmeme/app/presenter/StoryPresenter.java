package in.indianmeme.app.presenter;

import java.util.Map;

import in.indianmeme.app.ModelApi.Story.StoryFetch;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.StoryContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryPresenter implements StoryContract.UserStoryInterector {

    StoryContract.UserStoryView userStoryView;

    public StoryPresenter(StoryContract.UserStoryView userStoryView) {
        this.userStoryView = userStoryView;
    }

    @Override
    public void getData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getStory(map).enqueue(new Callback<StoryFetch>() {
            @Override
            public void onResponse(Call<StoryFetch> call, Response<StoryFetch> response) {
                int code = 200;
                if (response.code() == code) {
                    userStoryView.setLatestData(response.body());
                }
            }

            @Override
            public void onFailure(Call<StoryFetch> call, Throwable t) {

            }
        });

    }
}
