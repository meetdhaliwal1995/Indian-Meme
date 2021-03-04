package in.indianmeme.app.ModelApi.Story;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum implements Parcelable {

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("media_file")
    @Expose
    private String mediaFile;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("new")
    @Expose
    private Integer _new;
    @SerializedName("new_stories")
    @Expose
    private String newStories;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("owner")
    @Expose
    private Boolean owner;
    @SerializedName("stories")
    @Expose
    private List<Story> stories = null;

    protected Datum(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            userId = null;
        } else {
            userId = in.readInt();
        }
        caption = in.readString();
        time = in.readString();
        mediaFile = in.readString();
        type = in.readString();
        duration = in.readString();
        username = in.readString();
        fname = in.readString();
        lname = in.readString();
        avatar = in.readString();
        if (in.readByte() == 0) {
            _new = null;
        } else {
            _new = in.readInt();
        }
        newStories = in.readString();
        url = in.readString();
        name = in.readString();
        byte tmpOwner = in.readByte();
        owner = tmpOwner == 0 ? null : tmpOwner == 1;
        stories = in.createTypedArrayList(Story.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (userId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userId);
        }
        dest.writeString(caption);
        dest.writeString(time);
        dest.writeString(mediaFile);
        dest.writeString(type);
        dest.writeString(duration);
        dest.writeString(username);
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeString(avatar);
        if (_new == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(_new);
        }
        dest.writeString(newStories);
        dest.writeString(url);
        dest.writeString(name);
        dest.writeByte((byte) (owner == null ? 0 : owner ? 1 : 2));
        dest.writeTypedList(stories);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMediaFile() {
        return mediaFile;
    }

    public void setMediaFile(String mediaFile) {
        this.mediaFile = mediaFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getNew() {
        return _new;
    }

    public void setNew(Integer _new) {
        this._new = _new;
    }

    public String getNewStories() {
        return newStories;
    }

    public void setNewStories(String newStories) {
        this.newStories = newStories;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
}
