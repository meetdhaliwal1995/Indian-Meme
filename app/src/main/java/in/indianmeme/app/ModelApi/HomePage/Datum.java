package in.indianmeme.app.ModelApi.HomePage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {

    @SerializedName("post_id")
    @Expose
    private Integer postId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("youtube")
    @Expose
    private String youtube;
    @SerializedName("vimeo")
    @Expose
    private String vimeo;
    @SerializedName("dailymotion")
    @Expose
    private String dailymotion;
    @SerializedName("playtube")
    @Expose
    private String playtube;
    @SerializedName("mp4")
    @Expose
    private Object mp4;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("boosted")
    @Expose
    private Integer boosted;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    @SerializedName("media_set")
    @Expose
    private List<MediaSet> mediaSet = null;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("is_owner")
    @Expose
    private Boolean isOwner;
    @SerializedName("is_liked")
    @Expose
    private Boolean isLiked;
    @SerializedName("is_saved")
    @Expose
    private Boolean isSaved;
    @SerializedName("reported")
    @Expose
    private Boolean reported;
    @SerializedName("user_data")
    @Expose
    private UserData userData;
    @SerializedName("is_verified")
    @Expose
    private Integer isVerified;
    @SerializedName("is_should_hide")
    @Expose
    private Boolean isShouldHide;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("time_text")
    @Expose
    private String timeText;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getVimeo() {
        return vimeo;
    }

    public void setVimeo(String vimeo) {
        this.vimeo = vimeo;
    }

    public String getDailymotion() {
        return dailymotion;
    }

    public void setDailymotion(String dailymotion) {
        this.dailymotion = dailymotion;
    }

    public String getPlaytube() {
        return playtube;
    }

    public void setPlaytube(String playtube) {
        this.playtube = playtube;
    }

    public Object getMp4() {
        return mp4;
    }

    public void setMp4(Object mp4) {
        this.mp4 = mp4;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getBoosted() {
        return boosted;
    }

    public void setBoosted(Integer boosted) {
        this.boosted = boosted;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public List<MediaSet> getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(List<MediaSet> mediaSet) {
        this.mediaSet = mediaSet;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

    public Boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        this.isSaved = isSaved;
    }

    public Boolean getReported() {
        return reported;
    }

    public void setReported(Boolean reported) {
        this.reported = reported;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Boolean getIsShouldHide() {
        return isShouldHide;
    }

    public void setIsShouldHide(Boolean isShouldHide) {
        this.isShouldHide = isShouldHide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

}
