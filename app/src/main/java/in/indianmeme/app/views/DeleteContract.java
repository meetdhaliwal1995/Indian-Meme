package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Delete.DeletePost;

public interface DeleteContract {

    interface DelteView {


        void setLatestData(DeletePost deletePost);

    }

    interface DeleleInterecter {

        void getData(Map<String, Object> map);
    }
}



