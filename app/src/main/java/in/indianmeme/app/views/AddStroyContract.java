package in.indianmeme.app.views;

import in.indianmeme.app.ModelApi.AddStory.AddStoryUser;
import okhttp3.MultipartBody;

public interface AddStroyContract {

    interface AddStoryView {


        void setLatestData(AddStoryUser addStoryUser);

    }

    interface AddStoryInterecter {

        void getData(MultipartBody.Part file, MultipartBody.Part server_key, MultipartBody.Part access_token);
    }
}



