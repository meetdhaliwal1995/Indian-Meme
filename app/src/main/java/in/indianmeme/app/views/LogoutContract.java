package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.Logout.LogoutUser;

public interface LogoutContract {

    interface LogoutView {


        void setLatestData(LogoutUser logoutUser);

    }

    interface LogoutInterecter {

        void getData(Map<String, Object> map);
    }
}



