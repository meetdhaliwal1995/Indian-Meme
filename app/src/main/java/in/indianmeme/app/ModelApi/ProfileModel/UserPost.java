package in.indianmeme.app.ModelApi.ProfileModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserPost implements Parcelable {

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
    private List<Object> comments = null;
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
    private Object userData;
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
    @SerializedName("comment_counts")
    @Expose
    private Integer commentCounts;

    protected UserPost(Parcel in) {
        if (in.readByte() == 0) {
            postId = null;
        } else {
            postId = in.readInt();
        }
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        description = in.readString();
        link = in.readString();
        youtube = in.readString();
        vimeo = in.readString();
        dailymotion = in.readString();
        playtube = in.readString();
        time = in.readString();
        type = in.readString();
        registered = in.readString();
        if (in.readByte() == 0) {
            views = null;
        } else {
            views = in.readInt();
        }
        if (in.readByte() == 0) {
            boosted = null;
        } else {
            boosted = in.readInt();
        }
        avatar = in.readString();
        username = in.readString();
        if (in.readByte() == 0) {
            likes = null;
        } else {
            likes = in.readInt();
        }
        if (in.readByte() == 0) {
            votes = null;
        } else {
            votes = in.readInt();
        }
        mediaSet = in.createTypedArrayList(MediaSet.CREATOR);
        byte tmpIsOwner = in.readByte();
        isOwner = tmpIsOwner == 0 ? null : tmpIsOwner == 1;
        byte tmpIsLiked = in.readByte();
        isLiked = tmpIsLiked == 0 ? null : tmpIsLiked == 1;
        byte tmpIsSaved = in.readByte();
        isSaved = tmpIsSaved == 0 ? null : tmpIsSaved == 1;
        byte tmpReported = in.readByte();
        reported = tmpReported == 0 ? null : tmpReported == 1;
        if (in.readByte() == 0) {
            isVerified = null;
        } else {
            isVerified = in.readInt();
        }
        byte tmpIsShouldHide = in.readByte();
        isShouldHide = tmpIsShouldHide == 0 ? null : tmpIsShouldHide == 1;
        name = in.readString();
        timeText = in.readString();
        if (in.readByte() == 0) {
            commentCounts = null;
        } else {
            commentCounts = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (postId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(postId);
        }
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        dest.writeString(description);
        dest.writeString(link);
        dest.writeString(youtube);
        dest.writeString(vimeo);
        dest.writeString(dailymotion);
        dest.writeString(playtube);
        dest.writeString(time);
        dest.writeString(type);
        dest.writeString(registered);
        if (views == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(views);
        }
        if (boosted == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(boosted);
        }
        dest.writeString(avatar);
        dest.writeString(username);
        if (likes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(likes);
        }
        if (votes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(votes);
        }
        dest.writeTypedList(mediaSet);
        dest.writeByte((byte) (isOwner == null ? 0 : isOwner ? 1 : 2));
        dest.writeByte((byte) (isLiked == null ? 0 : isLiked ? 1 : 2));
        dest.writeByte((byte) (isSaved == null ? 0 : isSaved ? 1 : 2));
        dest.writeByte((byte) (reported == null ? 0 : reported ? 1 : 2));
        if (isVerified == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isVerified);
        }
        dest.writeByte((byte) (isShouldHide == null ? 0 : isShouldHide ? 1 : 2));
        dest.writeString(name);
        dest.writeString(timeText);
        if (commentCounts == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(commentCounts);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserPost> CREATOR = new Creator<UserPost>() {
        @Override
        public UserPost createFromParcel(Parcel in) {
            return new UserPost(in);
        }

        @Override
        public UserPost[] newArray(int size) {
            return new UserPost[size];
        }
    };

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

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
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

    public Object getUserData() {
        return userData;
    }

    public void setUserData(Object userData) {
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

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

}
