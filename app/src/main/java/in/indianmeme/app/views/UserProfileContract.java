package in.indianmeme.app.views;

import java.util.Map;

import in.indianmeme.app.ModelApi.ProfileModel.UserData;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfile;

public interface UserProfileContract {

    interface UserProfileView {

        void showProgress();

        void hideProgress();

        void setLatestData(UserProfile userProfile);

    }

    interface UserProfileInteractor {

        void getData(Map<String, Object> map);


    }
}
