package in.indianmeme.app;

import android.annotation.SuppressLint;
import android.app.Service;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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

import in.indianmeme.app.Adapters.AdapterGetChat;
import in.indianmeme.app.ModelApi.GetUserMsg.GetUserMsgModel;
import in.indianmeme.app.ModelApi.GetUserMsg.MessagesItem;
import in.indianmeme.app.ModelApi.ProfileModel.Data;
import in.indianmeme.app.ModelApi.SendMessage.SendMessageModel;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;

public class ActivityChatsMsg extends AppCompatActivity implements PostContract.PostView {
    ImageView userImage, userProfile;
    EditText message, postMsg;
    TextView userName, username, followers, post;
    RecyclerView recyclerView;
    PostPresenter postPresenter;
    Map<String, Object> map;
    AdapterGetChat adapterChat;
    String getUserId;

    Data data;

    @SuppressLint({"SetTextI18n", "WrongViewCast"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_msg);
        recyclerView = findViewById(R.id.recycler_chat);
        userImage = findViewById(R.id.user_profile_pic_chat);
        userProfile = findViewById(R.id.profile_dp_chat);
        userName = findViewById(R.id.username_topbar);
        username = findViewById(R.id.username_chat);
        followers = findViewById(R.id.followers_chat);
        post = findViewById(R.id.post_message);
        message = findViewById(R.id.sendmsg_edit);

        data = getIntent().getParcelableExtra("data");
        postPresenter = new PostPresenter(this);

        initCommentAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

//        adapterChat = new AdapterGetChat(this, new ArrayList<MessagesItem>());
//        recyclerView.setAdapter(adapterChat);

        getUserId = String.valueOf(getIntent().getIntExtra("userid", 0));


        map = new HashMap<>();
        map.put("access_token", PrefUtils.getAccessToken());
        map.put("server_key", Constant.SERVER_KEY);
//        map.put("user_id", data.getUserData().getUserId());
        map.put("user_id", getUserId);
        map.put("limit", 200);
        postPresenter.getUserMsg(map);
        Log.e("dddd", "map");

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(message, 0);
                message.requestFocus();
                Map<String, Object> sendMsg = new HashMap<>();
                sendMsg.put("access_token", PrefUtils.getAccessToken());
                sendMsg.put("server_key", Constant.SERVER_KEY);
                sendMsg.put("user_id", getUserId);
                sendMsg.put("text", message.getText().toString());
                sendMsg.put("hash_id", message.getText().toString().hashCode());
                postPresenter.getSendMessage(sendMsg);
                adapterChat.addMessage(messageConversion(Integer.parseInt(getUserId), message.getText().toString()));
                inputMethodManager.hideSoftInputFromWindow(message.getWindowToken(), 0);
                message.clearFocus();
                message.setText("");
                recyclerView.smoothScrollToPosition(10000);
            }
        });

    }

    private void initCommentAdapter() {
        if (adapterChat != null) {
            adapterChat.clearComments();
            recyclerView.setAdapter(null);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterChat = new AdapterGetChat(this, new ArrayList<MessagesItem>());
        recyclerView.setAdapter(adapterChat);
    }

    private MessagesItem messageConversion(int id, String text) {
        MessagesItem item = new MessagesItem();
        item.setId(id);
        item.setText(text);
        return item;
    }


    @Override
    public void setUserMsg(GetUserMsgModel getUserMsgModel) {
        Log.e("check", "adapter");
        adapterChat.addComment(getUserMsgModel.getData().getMessages());
        Glide.with(getApplicationContext()).load(getUserMsgModel.getData().getUserData().getAvatar()).circleCrop().into(userImage);
        username.setText(getUserMsgModel.getData().getUserData().getUsername());
        Glide.with(getApplicationContext()).load(getUserMsgModel.getData().getUserData().getAvatar()).circleCrop().into(userProfile);
        userName.setText(getUserMsgModel.getData().getUserData().getUsername());
        followers.setText(getUserMsgModel.getData().getUserData().getFollowers() + "  followers   " + ":  Total Post  " + getUserMsgModel.getData().getUserData().getPostsCount());
    }

    @Override
    public void setSendMessage(SendMessageModel sendMessageModel) {
//        in.indianmeme.app.ModelApi.SendMessage.Data data = sendMessageModel.getData();
//        adapterChat.addMessage(messageConversion(data.getId(), data.getText()));
    }
}
