package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddComments.AddComment;
import in.indianmeme.app.ModelApi.Comments.CommentInfo;

public interface AddCommentContract {

    interface AddCommentView {

        void showProgress();

        void hideProgress();


        void setLatestData(AddComment addComment);

        void showError(String error);
    }

    interface AddCommentInterector {

        void getData(Map<String, Object> map);
    }
}

