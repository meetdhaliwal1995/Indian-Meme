package in.indianmeme.app.ModelApi.AddStory;

public class AddStoryUser {
    private String code;
    private Data data;
    private int id;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "AddStoryUser{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",id = '" + id + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
