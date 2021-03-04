package in.indianmeme.app.presenter;

import java.io.IOException;
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
import in.indianmeme.app.ModelApi.LoginError.ErrorLoginModel;
import in.indianmeme.app.ModelApi.Logout.LogoutUserModel;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfileModel;
import in.indianmeme.app.ModelApi.Story.StoryFetchModel;
import in.indianmeme.app.ModelApi.UserData.UserDataModel;
import in.indianmeme.app.ModelApi.UserRegisterModel.UserRegisterModel;
import in.indianmeme.app.ModelApi.error.ErrorModelModel;
import in.indianmeme.app.MyApp;
import in.indianmeme.app.NetworkInterface;
import in.indianmeme.app.views.PostContract;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter implements PostContract.PostInterecter {

    private PostContract.PostView postView;


    public PostPresenter(PostContract.PostView postView) {
        this.postView = postView;
    }

    @Override
    public void getDeleteComment(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.deleteComment(map).enqueue(new Callback<DeleteCommentModel>() {
            @Override
            public void onResponse(Call<DeleteCommentModel> call, Response<DeleteCommentModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setDeleteCommentData(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeleteCommentModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getDeleteReply(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.deleteReply(map).enqueue(new Callback<DeleteReplyModel>() {
            @Override
            public void onResponse(Call<DeleteReplyModel> call, Response<DeleteReplyModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setDeleteReply(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeleteReplyModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAddComment(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addComment(map).enqueue(new Callback<AddCommentModel>() {
            @Override
            public void onResponse(Call<AddCommentModel> call, Response<AddCommentModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setAddComment(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddCommentModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAddImz(MultipartBody.Part images, MultipartBody.Part server_key, MultipartBody.Part access_token, MultipartBody.Part caption) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addImz(server_key, access_token, images, caption).enqueue(new Callback<AddPicModel>() {
            @Override
            public void onResponse(Call<AddPicModel> call, Response<AddPicModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setAddImz(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddPicModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAddStory(MultipartBody.Part file, MultipartBody.Part server_key, MultipartBody.Part access_token) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addStroy(server_key, access_token, file).enqueue(new Callback<AddStoryUser>() {
            @Override
            public void onResponse(Call<AddStoryUser> call, Response<AddStoryUser> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setAddStory(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddStoryUser> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAddVideo(MultipartBody.Part video, MultipartBody.Part server_key, MultipartBody.Part access_token, MultipartBody.Part thumb, MultipartBody.Part caption) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.addVideo(server_key, access_token, video, thumb, caption).enqueue(new Callback<AddPicModel>() {
            @Override
            public void onResponse(Call<AddPicModel> call, Response<AddPicModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setAddVideo(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddPicModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUserComment(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getComments(map).enqueue(new Callback<CommentInfoModel>() {
            @Override
            public void onResponse(Call<CommentInfoModel> call, Response<CommentInfoModel> response) {
                int code = 200;
                if (code == response.code()) {
                    postView.setUserComment(response.body());
                }
            }

            @Override
            public void onFailure(Call<CommentInfoModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getDeletePost(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.deletePost(map).enqueue(new Callback<DeletePostModel>() {
            @Override
            public void onResponse(Call<DeletePostModel> call, Response<DeletePostModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setDeletePost(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeletePostModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getFetchReply(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.replyFetch(map).enqueue(new Callback<FetchReplyModel>() {
            @Override
            public void onResponse(Call<FetchReplyModel> call, Response<FetchReplyModel> response) {
                int code = 200;
                if (response.code() == 200) {
                    postView.setFetchReply(response.body());
                }
            }

            @Override
            public void onFailure(Call<FetchReplyModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getFollow(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userFollow(map).enqueue(new Callback<FollowUserModel>() {
            @Override
            public void onResponse(Call<FollowUserModel> call, Response<FollowUserModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setFollowUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<FollowUserModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getLike(Map<String, Object> map) {
        NetworkInterface ne = MyApp.getRetrofit().create(NetworkInterface.class);
        ne.addLike(map).enqueue(new Callback<LikesUnlikeModel>() {
            @Override
            public void onResponse(Call<LikesUnlikeModel> call, Response<LikesUnlikeModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setLike(response.body());
                }
            }

            @Override
            public void onFailure(Call<LikesUnlikeModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUserLogin(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userLogin(map).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setUserLogin(response.body());
                } else {
                    try {
                        String error = response.errorBody().string();
                        ErrorLoginModel errorLoginModel = MyApp.getGson().fromJson(error, ErrorLoginModel.class);
                        postView.showError(errorLoginModel.getErrors().getErrorText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getLogout(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.logoutUser(map).enqueue(new Callback<LogoutUserModel>() {
            @Override
            public void onResponse(Call<LogoutUserModel> call, Response<LogoutUserModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setLogoutUser(response.body());
                }
            }

            @Override
            public void onFailure(Call<LogoutUserModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getPostExplore(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.postExplore(map).enqueue(new Callback<PostExploreModel>() {
            @Override
            public void onResponse(Call<PostExploreModel> call, Response<PostExploreModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setPostExplore(response.body());
                }
            }

            @Override
            public void onFailure(Call<PostExploreModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getPostHome(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.homePage(map).enqueue(new Callback<HomePageDataModel>() {
            @Override
            public void onResponse(Call<HomePageDataModel> call, Response<HomePageDataModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setHomePagePost(response.body());
                }
            }

            @Override
            public void onFailure(Call<HomePageDataModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUseregister(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);


        networkInterface.registerUser(map).enqueue(new Callback<UserRegisterModel>() {
            @Override
            public void onResponse(Call<UserRegisterModel> call, Response<UserRegisterModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setUserRegister(response.body());
                } else {
                    try {
                        String err = response.errorBody().string();
                        ErrorModelModel errorModel = MyApp.getGson().fromJson(err, ErrorModelModel.class);
                        postView.showError(errorModel.getErrors().getErrorText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserRegisterModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getStory(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getStory(map).enqueue(new Callback<StoryFetchModel>() {
            @Override
            public void onResponse(Call<StoryFetchModel> call, Response<StoryFetchModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setStory(response.body());
                }
            }

            @Override
            public void onFailure(Call<StoryFetchModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAddReply(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userRplyAdd(map).enqueue(new Callback<AddReplyModel>() {
            @Override
            public void onResponse(Call<AddReplyModel> call, Response<AddReplyModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setAddReply(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddReplyModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUserData(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userData(map).enqueue(new Callback<UserDataModel>() {
            @Override
            public void onResponse(Call<UserDataModel> call, Response<UserDataModel> response) {
                int code = 200;
                if (response.code() == code) {
                    postView.setUserData(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserDataModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUserProfile(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.userProfile(map).enqueue(new Callback<UserProfileModel>() {
            @Override
            public void onResponse(Call<UserProfileModel> call, Response<UserProfileModel> response) {
                int code = 200;
                if (code == response.code()) {
                    postView.setUserProfile(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserProfileModel> call, Throwable t) {

            }
        });
    }
}
