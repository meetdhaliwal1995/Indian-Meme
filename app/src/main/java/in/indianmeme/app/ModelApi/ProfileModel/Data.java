package in.indianmeme.app.ModelApi.ProfileModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("user_data")
    @Expose
    private UserData userData;
    @SerializedName("total_posts")
    @Expose
    private Integer totalPosts;
    @SerializedName("user_followers")
    @Expose
    private Integer userFollowers;
    @SerializedName("user_following")
    @Expose
    private Integer userFollowing;
    @SerializedName("profile_privacy")
    @Expose
    private Boolean profilePrivacy;
    @SerializedName("chat_privacy")
    @Expose
    private Boolean chatPrivacy;
    @SerializedName("is_owner")
    @Expose
    private Boolean isOwner;
    @SerializedName("is_following")
    @Expose
    private Boolean isFollowing;
    @SerializedName("is_reported")
    @Expose
    private Boolean isReported;
    @SerializedName("is_blocked")
    @Expose
    private Boolean isBlocked;
    @SerializedName("ami_blocked")
    @Expose
    private Boolean amiBlocked;
    @SerializedName("user_posts")
    @Expose
    private List<UserPost> userPosts = null;

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Integer getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(Integer totalPosts) {
        this.totalPosts = totalPosts;
    }

    public Integer getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(Integer userFollowers) {
        this.userFollowers = userFollowers;
    }

    public Integer getUserFollowing() {
        return userFollowing;
    }

    public void setUserFollowing(Integer userFollowing) {
        this.userFollowing = userFollowing;
    }

    public Boolean getProfilePrivacy() {
        return profilePrivacy;
    }

    public void setProfilePrivacy(Boolean profilePrivacy) {
        this.profilePrivacy = profilePrivacy;
    }

    public Boolean getChatPrivacy() {
        return chatPrivacy;
    }

    public void setChatPrivacy(Boolean chatPrivacy) {
        this.chatPrivacy = chatPrivacy;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getIsFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(Boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

    public Boolean getIsReported() {
        return isReported;
    }

    public void setIsReported(Boolean isReported) {
        this.isReported = isReported;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Boolean getAmiBlocked() {
        return amiBlocked;
    }

    public void setAmiBlocked(Boolean amiBlocked) {
        this.amiBlocked = amiBlocked;
    }

    public List<UserPost> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<UserPost> userPosts) {
        this.userPosts = userPosts;
    }

}
