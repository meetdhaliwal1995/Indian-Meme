package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.AddUserReply.AddReplyModel;

public interface AddRplyContract {

    interface AddRplyView {


        void setLatestData(AddReplyModel addReplyModel);

    }

    interface AddRplyInterecter {

        void getData(Map<String, Object> map);
    }
}



