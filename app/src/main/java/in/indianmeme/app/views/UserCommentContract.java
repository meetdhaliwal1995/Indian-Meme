package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Comments.CommentInfo;

public interface UserCommentContract {

    interface UserCommentView {

        void showProgress();

        void hideProgress();


        void setLatestData(CommentInfo commentInfo);

        void showError(String error);
    }

    interface UserCommentInterector {

        void getData(Map<String, Object> map);
    }
}

