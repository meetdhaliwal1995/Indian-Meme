package in.indianmeme.app;

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
import in.indianmeme.app.ModelApi.GetChat.GetChatModel;
import in.indianmeme.app.ModelApi.GetUserMsg.GetUserMsgModel;
import in.indianmeme.app.ModelApi.HomePage.HomePageDataModel;
import in.indianmeme.app.ModelApi.Login.LoginModel;
import in.indianmeme.app.ModelApi.Logout.LogoutUserModel;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfileModel;
import in.indianmeme.app.ModelApi.Story.StoryFetchModel;
import in.indianmeme.app.ModelApi.UserData.UserDataModel;
import in.indianmeme.app.ModelApi.UserRegisterModel.UserRegisterModel;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface NetworkInterface {

    @POST(Constant.USER_REGISTER)
    @FormUrlEncoded
    Call<UserRegisterModel> registerUser(@FieldMap Map<String, Object> data);

    @POST(Constant.USER_LOGIN)
    @FormUrlEncoded
    Call<LoginModel> userLogin(@FieldMap Map<String, Object> map);

    @POST(Constant.USER_PROFILE)
    @FormUrlEncoded
    Call<UserProfileModel> userProfile(@FieldMap Map<String, Object> map);

    @POST(Constant.HOME_PAGE)
    @FormUrlEncoded
    Call<HomePageDataModel> homePage(@FieldMap Map<String, Object> map);

    @POST(Constant.EXPLORE_DATA)
    @FormUrlEncoded
    Call<PostExploreModel> postExplore(@FieldMap Map<String, Object> map);

    @POST(Constant.GET_COMMENT)
    @FormUrlEncoded
    Call<CommentInfoModel> getComments(@FieldMap Map<String, Object> map);

    @POST(Constant.GET_STORY)
    @FormUrlEncoded
    Call<StoryFetchModel> getStory(@FieldMap Map<String, Object> map);

    @POST(Constant.ADD_COMMENT)
    @FormUrlEncoded
    Call<AddCommentModel> addComment(@FieldMap Map<String, Object> map);

    @POST(Constant.DELETE_POST)
    @FormUrlEncoded
    Call<DeletePostModel> deletePost(@FieldMap Map<String, Object> map);

    @POST(Constant.LOGOUT_USER)
    @FormUrlEncoded
    Call<LogoutUserModel> logoutUser(@FieldMap Map<String, Object> map);

    @POST(Constant.ADD_LIKE)
    @FormUrlEncoded
    Call<LikesUnlikeModel> addLike(@FieldMap Map<String, Object> map);

    @Multipart
    @POST(Constant.ADD_IMZ)
    Call<AddPicModel> addImz(@Part MultipartBody.Part server_key,
                             @Part MultipartBody.Part access_token,
                             @Part MultipartBody.Part image,
                             @Part MultipartBody.Part other);

    @Multipart
    @POST(Constant.ADD_STORY)
    Call<AddStoryUser> addStroy(@Part MultipartBody.Part server_key,
                                @Part MultipartBody.Part access_token,
                                @Part MultipartBody.Part image);

    @Multipart
    @POST(Constant.ADD_IMZ)
    Call<AddPicModel> addVideo(@Part MultipartBody.Part server_key,
                               @Part MultipartBody.Part access_token,
                               @Part MultipartBody.Part video,
                               @Part MultipartBody.Part thumb,
                               @Part MultipartBody.Part caption);

    @POST(Constant.FOLLOW_USER)
    @FormUrlEncoded
    Call<FollowUserModel> userFollow(@FieldMap Map<String, Object> map);

    @POST(Constant.FETCH_REPLY)
    @FormUrlEncoded
    Call<FetchReplyModel> replyFetch(@FieldMap Map<String, Object> map);


    @POST(Constant.ADD_REPLY)
    @FormUrlEncoded
    Call<AddReplyModel> userRplyAdd(@FieldMap Map<String, Object> map);

    @POST(Constant.USER_DATA)
    @FormUrlEncoded
    Call<UserDataModel> userData(@FieldMap Map<String, Object> map);

    @POST(Constant.DELETE_COMMENT)
    @FormUrlEncoded
    Call<DeleteCommentModel> deleteComment(@FieldMap Map<String, Object> map);

    @POST(Constant.DELETE_REPLY)
    @FormUrlEncoded
    Call<DeleteReplyModel> deleteReply(@FieldMap Map<String, Object> map);

    @POST(Constant.GET_CHAT)
    @FormUrlEncoded
    Call<GetChatModel> getChat(@FieldMap Map<String, Object> map);

    @POST(Constant.GET_USER_MSG)
    @FormUrlEncoded
    Call<GetUserMsgModel> getUserMsg(@FieldMap Map<String, Object> map);

}
