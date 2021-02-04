package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Comments.CommentInfo;
import in.indianmeme.app.ModelApi.Story.StoryFetch;

public interface StoryContract {

    interface UserStoryView {

        void showProgress();

        void hideProgress();

        void setLatestData(StoryFetch storyFetch);

        void showError(String error);
    }

    interface UserStoryInterector {

        void getData(Map<String, Object> map);
    }
}

