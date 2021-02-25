package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Follow.FollowUserModel;

public interface FollowContract {

    interface FollowView {


        void setLatestData(FollowUserModel followUserModel);

    }

    interface FollowInterecter {

        void getData(Map<String, Object> map);
    }
}



