package in.indianmeme.app.ModelApi.UserRegisterModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegisterModel {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
