package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.ExplorePosts.PostExplore;

public interface PostHomeExploreContract {

    interface ExploreView {

        void showProgress();

        void hideProgress();

        void setLatestData(PostExplore postExplore);

        void showError(String error);
    }

    interface ExploreInterector {

        void getData(Map<String, Object> map);


    }
}
