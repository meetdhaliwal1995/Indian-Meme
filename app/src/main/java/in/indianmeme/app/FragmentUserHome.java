package in.indianmeme.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import in.indianmeme.app.ModelApi.Follow.FollowUserModel;
import in.indianmeme.app.ModelApi.ProfileModel.UserProfileModel;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;


public class FragmentUserHome extends Fragment implements PostContract.PostView {
    TextView userName, userLocation, posts, followers, following, about, getUserName, follow, message;
    ImageView profileImage, home, add;
    RecyclerView recyclerView;
    int getid;
    Map<String, Object> map;
    PostPresenter postPresenter;
    UserProfileModel userProfileModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otheruser_allinfo, container, false);
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
        follow = view.findViewById(R.id.text_follow);
        message = view.findViewById(R.id.text_message);


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        postPresenter = new PostPresenter(this);
        String access_token = PrefUtils.getAccessToken();
        String server_key = Constant.SERVER_KEY;


        map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("server_key", server_key);
        map.put("user_id", getid);
//        userProfilePresenter.getData(map);
        postPresenter.getUserProfile(map);

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postPresenter.getFollow(map);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityChatsMsg.class);
                intent.putExtra("userid", userProfileModel.getData().getUserData().getUserId());
                startActivity(intent);
            }
        });

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void setUserProfile(UserProfileModel userProfile) {
        Log.e("chech", "profile");
        userProfileModel = userProfile;

        boolean is_following = userProfile.getData().getIsFollowing();

        if (is_following) {
            follow.setText(R.string.Unfollow);
            follow.setBackgroundResource(R.drawable.circle_off);
        }
        getUserName.setText(userProfile.getData().getUserData().getUsername());
        posts.setText(String.valueOf(userProfile.getData().getUserData().getPostsCount()));
        Glide.with(getContext()).load(userProfile.getData().getUserData().getAvatar()).circleCrop().into(profileImage);
        followers.setText(String.valueOf(userProfile.getData().getUserFollowers()));
        following.setText(String.valueOf(userProfile.getData().getUserFollowing()));
        about.setText(String.valueOf(userProfile.getData().getUserData().getAbout()));
        AdapterUser adapterUser = new AdapterUser(getContext(), userProfile.getData().getUserPosts());
        recyclerView.setAdapter(adapterUser);
    }

    public void setid(int userid) {
        getid = userid;
    }


    @Override
    public void setFollowUser(FollowUserModel followUserModel) {
        int type = followUserModel.getType();


        if (type == 1) {
            int countFollowers = Integer.parseInt(followers.getText().toString()) + 1;
            followers.setText(String.valueOf(countFollowers));
            follow.setText(R.string.Unfollow);
            follow.setBackgroundResource(R.drawable.circle_off);
        } else {
            int countFollowers = Integer.parseInt(followers.getText().toString()) - 1;
            followers.setText(String.valueOf(countFollowers));
            follow.setText(R.string.follow);
            follow.setBackgroundResource(R.drawable.circle_on);
        }
    }
}
