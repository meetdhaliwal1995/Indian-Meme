package in.indianmeme.app.ModelApi.AddStory;

public class Data {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "message = '" + message + '\'' +
                        "}";
    }
}
