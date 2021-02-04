package in.indianmeme.app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterUser;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfile;
import in.indianmeme.app.presenter.UserProfilePresenter;
import in.indianmeme.app.views.UserProfileContract;

public class ActivityUserHome extends AppCompatActivity implements UserProfileContract.UserProfileView {
    TextView userName, userLocation, posts, followers, following, about, getUserName;
    ImageView profileImage, home, add;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_allinfo);

        about = findViewById(R.id.text_bio);
        userName = findViewById(R.id.text_name);
        userLocation = findViewById(R.id.text_location);
        profileImage = findViewById(R.id.profile_image);
        posts = findViewById(R.id.total_post);
        followers = findViewById(R.id.total_followers);
        following = findViewById(R.id.total_following);
        recyclerView = findViewById(R.id.recycler_id);
        getUserName = findViewById(R.id.username);
        home = findViewById(R.id.home_burger);
        add = findViewById(R.id.add_pic);

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));

        UserProfilePresenter userProfilePresenter = new UserProfilePresenter(this);

        String access_token = PrefUtils.getAccessToken();
        String server_key = Constant.SERVER_KEY;
        String user_id = String.valueOf(getIntent().getStringExtra("getUserId"));
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("server_key", server_key);
        map.put("user_id", user_id);
        userProfilePresenter.getData(map);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setLatestData(UserProfile userProfile) {

        userName.setText(userProfile.getData().getUserData().getUsername());
        getUserName.setText(userProfile.getData().getUserData().getUsername());
        posts.setText(String.valueOf(userProfile.getData().getUserData().getPostsCount()));
        Glide.with(getApplicationContext()).load(userProfile.getData().getUserData().getAvatar()).circleCrop().into(profileImage);
        followers.setText(String.valueOf(userProfile.getData().getUserFollowers()));
        following.setText(String.valueOf(userProfile.getData().getUserFollowing()));
        about.setText(String.valueOf(userProfile.getData().getUserData().getAbout()));
        AdapterUser adapterUser = new AdapterUser(getApplicationContext(), userProfile.getData().getUserPosts());
        recyclerView.setAdapter(adapterUser);
    }
}
