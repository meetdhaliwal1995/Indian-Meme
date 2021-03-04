package in.indianmeme.app.ModelApi.DlteCommt;

import com.google.gson.annotations.SerializedName;

public class DeleteCommentModel {

    @SerializedName("code")
    private String code;

    @SerializedName("status")
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "DeleteCommntModel{" +
                        "code = '" + code + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}