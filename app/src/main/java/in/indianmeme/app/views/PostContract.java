package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddComments.AddCommentModel;
import in.indianmeme.app.ModelApi.AddImz.AddPicModel;
import in.indianmeme.app.ModelApi.AddLike.LikesUnlikeModel;
import in.indianmeme.app.ModelApi.AddStory.AddStoryUser;
import in.indianmeme.app.ModelApi.AddUserReply.AddReplyModel;
import in.indianmeme.app.ModelApi.Comments.CommentInfoModel;
import in.indianmeme.app.ModelApi.CommentsRply.FetchReplyModel;
import in.indianmeme.app.ModelApi.Delete.DeletePostModel;
import in.indianmeme.app.ModelApi.DeleteReply.DeleteReplyModel;
import in.indianmeme.app.ModelApi.DlteCommt.DeleteCommentModel;
import in.indianmeme.app.ModelApi.ExplorePosts.PostExploreModel;
import in.indianmeme.app.ModelApi.Follow.FollowUserModel;
import in.indianmeme.app.ModelApi.HomePage.HomePageDataModel;
import in.indianmeme.app.ModelApi.Login.LoginModel;
import in.indianmeme.app.ModelApi.Logout.LogoutUserModel;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfileModel;
import in.indianmeme.app.ModelApi.Story.StoryFetchModel;
import in.indianmeme.app.ModelApi.UserData.UserDataModel;
import in.indianmeme.app.ModelApi.UserRegisterModel.UserRegisterModel;
import okhttp3.MultipartBody;

public interface PostContract {

    interface PostView {

        default void showProgress() {

        }

        default void hideProgress() {

        }

        default void showError(String error) {

        }


        default void setDeleteCommentData(DeleteCommentModel deleteComment) {

        }

        default void setDeleteReply(DeleteReplyModel deleteReplyModel) {

        }

        default void setAddImz(AddPicModel addPic) {

        }

        default void setAddComment(AddCommentModel addComment) {

        }

        default void setAddReply(AddReplyModel addReplyModel) {

        }

        default void setAddStory(AddStoryUser addStoryUser) {

        }

        default void setAddVideo(AddPicModel addPic) {

        }

        default void setDeletePost(DeletePostModel deletePost) {

        }

        default void setFetchReply(FetchReplyModel fetchReplyModel) {

        }

        default void setFollowUser(FollowUserModel followUserModel) {

        }

        default void setLike(LikesUnlikeModel likesUnlike) {

        }

        default void setLogoutUser(LogoutUserModel logoutUser) {

        }

        default void setPostExplore(PostExploreModel postExplore) {

        }

        default void setHomePagePost(HomePageDataModel homePageDataModel) {

        }

        default void setStory(StoryFetchModel storyFetch) {

        }

        default void setUserComment(CommentInfoModel commentInfo) {

        }

        default void setUserData(UserDataModel userDataModel) {

        }

        default void setUserLogin(LoginModel loginModel) {

        }

        default void setUserProfile(UserProfileModel userProfile) {

        }

        default void setUserRegister(UserRegisterModel userRegister) {

        }
    }

    interface PostInterecter {

        default void getDeleteComment(Map<String, Object> map) {

        }

        default void getDeleteReply(Map<String, Object> map) {

        }

        default void getAddComment(Map<String, Object> map) {

        }

        default void getAddImz(MultipartBody.Part images, MultipartBody.Part server_key, MultipartBody.Part access_token, MultipartBody.Part caption) {

        }

        default void getAddReply(Map<String, Object> map) {

        }

        default void getAddStory(MultipartBody.Part file, MultipartBody.Part server_key, MultipartBody.Part access_token) {

        }

        default void getAddVideo(MultipartBody.Part video, MultipartBody.Part server_key, MultipartBody.Part access_token, MultipartBody.Part thumb, MultipartBody.Part caption) {

        }

        default void getDeletePost(Map<String, Object> map) {

        }

        default void getFetchReply(Map<String, Object> map) {

        }

        default void getFollow(Map<String, Object> map) {

        }

        default void getLike(Map<String, Object> map) {

        }

        default void getLogout(Map<String, Object> map) {

        }

        default void getPostExplore(Map<String, Object> map) {

        }

        default void getPostHome(Map<String, Object> map) {

        }

        default void getStory(Map<String, Object> map) {

        }

        default void getUserComment(Map<String, Object> map) {

        }

        default void getUserData(Map<String, Object> map) {

        }

        default void getUserLogin(Map<String, Object> map) {

        }

        default void getUserProfile(Map<String, Object> map) {

        }

        default void getUseregister(Map<String, Object> map) {

        }

    }
}



