package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.ExplorePosts.PostExploreModel;

public interface PostHomeExploreContract {

    interface ExploreView {

        void showProgress();

        void hideProgress();

        void setLatestData(PostExploreModel postExplore);

        void showError(String error);
    }

    interface ExploreInterector {

        void getData(Map<String, Object> map);


    }
}
