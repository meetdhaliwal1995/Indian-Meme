package in.indianmeme.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterChat;
import in.indianmeme.app.ModelApi.GetUserMsg.GetUserMsgModel;
import in.indianmeme.app.ModelApi.GetUserMsg.MessagesItem;
import in.indianmeme.app.ModelApi.ProfileModel.Data;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;

public class ActivityChats extends AppCompatActivity implements PostContract.PostView {
    ImageView userImage, userProfile;
    TextView userName, username, followers, post;
    RecyclerView recyclerView;
    PostPresenter postPresenter;
    Map<String, Object> map;
    AdapterChat adapterChat;

    Data data;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        recyclerView = findViewById(R.id.recycler_chat);
        userImage = findViewById(R.id.user_profile_pic_chat);
        userProfile = findViewById(R.id.profile_dp_chat);
        userName = findViewById(R.id.username_topbar);
        username = findViewById(R.id.username_chat);
        followers = findViewById(R.id.followers_chat);
        post = findViewById(R.id.post_chat);

        data = getIntent().getParcelableExtra("data");
        postPresenter = new PostPresenter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterChat = new AdapterChat(this, new ArrayList<MessagesItem>());
        recyclerView.setAdapter(adapterChat);

        Glide.with(getApplicationContext()).load(data.getUserData().getAvatar()).circleCrop().into(userImage);
        username.setText(data.getUserData().getUsername());
        Glide.with(getApplicationContext()).load(data.getUserData().getAvatar()).circleCrop().into(userProfile);
        userName.setText(data.getUserData().getUsername());
        followers.setText(data.getUserData().getFollowers() + "  followers   " + ":  Total Post  " + data.getUserData().getPostsCount());
        post.setText(data.getUserData().getName());

        map = new HashMap<>();
        map.put("access_token", PrefUtils.getAccessToken());
        map.put("server_key", Constant.SERVER_KEY);
        map.put("user_id", data.getUserData().getUserId());
        map.put("limit", 200);
        postPresenter.getUserMsg(map);
        Log.e("dddd", "map");


    }

    @Override
    public void setUserMsg(GetUserMsgModel getUserMsgModel) {
        Log.e("check", "adapter");
        adapterChat.addComment(getUserMsgModel.getData().getMessages());
    }
}
