package in.indianmeme.app;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddComments.AddComment;
import in.indianmeme.app.ModelApi.AddPost.AddPic;
import in.indianmeme.app.ModelApi.Comments.CommentInfo;
import in.indianmeme.app.ModelApi.Delete.DeletePost;
import in.indianmeme.app.ModelApi.ExplorePosts.PostExplore;
import in.indianmeme.app.ModelApi.HomePage.HomePageData;
import in.indianmeme.app.ModelApi.Login.LoginModel;
import in.indianmeme.app.ModelApi.Logout.LogoutUser;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfile;
import in.indianmeme.app.ModelApi.Story.StoryFetch;
import in.indianmeme.app.ModelApi.UserRegisterModel.UserRegister;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NetworkInterface {

    @POST(Constant.USER_REGISTER)
    @FormUrlEncoded
    Call<UserRegister> registerUser(@FieldMap Map<String, Object> data);

    @POST(Constant.USER_LOGIN)
    @FormUrlEncoded
    Call<LoginModel> userLogin(@FieldMap Map<String, Object> map);

    @POST(Constant.USER_PROFILE)
    @FormUrlEncoded
    Call<UserProfile> userProfile(@FieldMap Map<String, Object> map);

    @POST(Constant.HOME_PAGE)
    @FormUrlEncoded
    Call<HomePageData> homePage(@FieldMap Map<String, Object> map);

    @POST(Constant.HOME_PAGE)
    @FormUrlEncoded
    Call<PostExplore> postExplore(@FieldMap Map<String, Object> map);

    @POST(Constant.GET_COMMENT)
    @FormUrlEncoded
    Call<CommentInfo> getComments(@FieldMap Map<String, Object> map);

    @POST(Constant.GET_STORY)
    @FormUrlEncoded
    Call<StoryFetch> getStory(@FieldMap Map<String, Object> map);

    @POST(Constant.ADD_POST)
    @FormUrlEncoded
    Call<AddPic> addPost(@FieldMap Map<String, Object> map);

    @POST(Constant.ADD_COMMENT)
    @FormUrlEncoded
    Call<AddComment> addComment(@FieldMap Map<String, Object> map);

    @POST(Constant.DELETE_POST)
    @FormUrlEncoded
    Call<DeletePost> deletePost(@FieldMap Map<String, Object> map);

    @POST(Constant.LOGOUT_USER)
    @FormUrlEncoded
    Call<LogoutUser> logoutUser(@FieldMap Map<String, Object> map);

}
