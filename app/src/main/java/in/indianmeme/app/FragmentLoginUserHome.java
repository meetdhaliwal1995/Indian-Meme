package in.indianmeme.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterUser;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfileModel;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;

public class FragmentLoginUserHome extends Fragment implements PostContract.PostView {
    TextView userName, userLocation, posts, followers, following, about, getUserName;
    ImageView profileImage, home, add;
    RecyclerView recyclerView;
    PostPresenter postPresenter;
    ProgressBar progressBar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_allinfo, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        about = view.findViewById(R.id.text_bio);
        userName = view.findViewById(R.id.text_name);
        userLocation = view.findViewById(R.id.text_location);
        profileImage = view.findViewById(R.id.profile_image);
        posts = view.findViewById(R.id.total_post);
        followers = view.findViewById(R.id.total_followers);
        following = view.findViewById(R.id.total_following);
        recyclerView = view.findViewById(R.id.recycler_id);
        getUserName = view.findViewById(R.id.username);
        home = view.findViewById(R.id.home_burger);
        add = view.findViewById(R.id.add_pic);
        progressBar = view.findViewById(R.id.spin_kit_user_home);


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        postPresenter = new PostPresenter(this);

        String access_token = PrefUtils.getAccessToken();
        String server_key = Constant.SERVER_KEY;
        String user_id = String.valueOf(PrefUtils.getUserId());


        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("server_key", server_key);
        map.put("user_id", user_id);
//        userProfilePresenter.getData(map);
        postPresenter.getUserProfile(map);

    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserProfile(UserProfileModel userProfile) {

        userName.setText(userProfile.getData().getUserData().getUsername());
        getUserName.setText(userProfile.getData().getUserData().getUsername());
        posts.setText(String.valueOf(userProfile.getData().getUserData().getPostsCount()));
        Glide.with(getContext()).load(userProfile.getData().getUserData().getAvatar()).circleCrop().into(profileImage);
        followers.setText(String.valueOf(userProfile.getData().getUserFollowers()));
        following.setText(String.valueOf(userProfile.getData().getUserFollowing()));
        about.setText(String.valueOf(userProfile.getData().getUserData().getAbout()));
        AdapterUser adapterUser = new AdapterUser(getContext(), userProfile.getData().getUserPosts());
        recyclerView.setAdapter(adapterUser);
    }
}
