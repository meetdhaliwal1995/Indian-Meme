package in.indianmeme.app.ModelApi.Story;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Story implements Parcelable {

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
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("owner")
    @Expose
    private Boolean owner;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("sf")
    @Expose
    private Boolean sf;
    @SerializedName("time_text")
    @Expose
    private String timeText;

    protected Story(Parcel in) {
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
        if (in.readByte() == 0) {
            views = null;
        } else {
            views = in.readInt();
        }
        byte tmpOwner = in.readByte();
        owner = tmpOwner == 0 ? null : tmpOwner == 1;
        src = in.readString();
        byte tmpSf = in.readByte();
        sf = tmpSf == 0 ? null : tmpSf == 1;
        timeText = in.readString();
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Boolean getSf() {
        return sf;
    }

    public void setSf(Boolean sf) {
        this.sf = sf;
    }

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    @Override
    public int describeContents() {
        return 0;
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
        if (views == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(views);
        }
        dest.writeByte((byte) (owner == null ? 0 : owner ? 1 : 2));
        dest.writeString(src);
        dest.writeByte((byte) (sf == null ? 0 : sf ? 1 : 2));
        dest.writeString(timeText);
    }
}
