package in.indianmeme.app.ModelApi.ExplorePosts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaSet {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("post_id")
    @Expose
    private Integer postId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("extra")
    @Expose
    private String extra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

}
