package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Delete.DeletePostModel;

public interface DeleteContract {

    interface DelteView {


        void setLatestData(DeletePostModel deletePost);

    }

    interface DeleleInterecter {

        void getData(Map<String, Object> map);
    }
}



