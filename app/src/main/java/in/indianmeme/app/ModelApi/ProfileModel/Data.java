package in.indianmeme.app.ModelApi.ProfileModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data implements Parcelable {

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

    protected Data(Parcel in) {
        userData = in.readParcelable(UserData.class.getClassLoader());
        if (in.readByte() == 0) {
            totalPosts = null;
        } else {
            totalPosts = in.readInt();
        }
        if (in.readByte() == 0) {
            userFollowers = null;
        } else {
            userFollowers = in.readInt();
        }
        if (in.readByte() == 0) {
            userFollowing = null;
        } else {
            userFollowing = in.readInt();
        }
        byte tmpProfilePrivacy = in.readByte();
        profilePrivacy = tmpProfilePrivacy == 0 ? null : tmpProfilePrivacy == 1;
        byte tmpChatPrivacy = in.readByte();
        chatPrivacy = tmpChatPrivacy == 0 ? null : tmpChatPrivacy == 1;
        byte tmpIsOwner = in.readByte();
        isOwner = tmpIsOwner == 0 ? null : tmpIsOwner == 1;
        byte tmpIsFollowing = in.readByte();
        isFollowing = tmpIsFollowing == 0 ? null : tmpIsFollowing == 1;
        byte tmpIsReported = in.readByte();
        isReported = tmpIsReported == 0 ? null : tmpIsReported == 1;
        byte tmpIsBlocked = in.readByte();
        isBlocked = tmpIsBlocked == 0 ? null : tmpIsBlocked == 1;
        byte tmpAmiBlocked = in.readByte();
        amiBlocked = tmpAmiBlocked == 0 ? null : tmpAmiBlocked == 1;
        userPosts = in.createTypedArrayList(UserPost.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(userData, flags);
        if (totalPosts == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalPosts);
        }
        if (userFollowers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userFollowers);
        }
        if (userFollowing == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userFollowing);
        }
        dest.writeByte((byte) (profilePrivacy == null ? 0 : profilePrivacy ? 1 : 2));
        dest.writeByte((byte) (chatPrivacy == null ? 0 : chatPrivacy ? 1 : 2));
        dest.writeByte((byte) (isOwner == null ? 0 : isOwner ? 1 : 2));
        dest.writeByte((byte) (isFollowing == null ? 0 : isFollowing ? 1 : 2));
        dest.writeByte((byte) (isReported == null ? 0 : isReported ? 1 : 2));
        dest.writeByte((byte) (isBlocked == null ? 0 : isBlocked ? 1 : 2));
        dest.writeByte((byte) (amiBlocked == null ? 0 : amiBlocked ? 1 : 2));
        dest.writeTypedList(userPosts);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

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
