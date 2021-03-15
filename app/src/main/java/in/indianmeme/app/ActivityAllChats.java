package in.indianmeme.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterAllChatActivity;
import in.indianmeme.app.ModelApi.GetChat.DataItem;
import in.indianmeme.app.ModelApi.GetChat.GetChatModel;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;

public class ActivityAllChats extends AppCompatActivity implements PostContract.PostView, AdapterAllChatActivity.AdapterCallChat {
    RecyclerView recyclerView;
    PostPresenter postPresenter;
    Map<String, Object> map;
    AdapterAllChatActivity adapterChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_chat);
        recyclerView = findViewById(R.id.recycler_getChat);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postPresenter = new PostPresenter(this);
        map = new HashMap<>();
        map.put("access_token", PrefUtils.getAccessToken());
        map.put("server_key", Constant.SERVER_KEY);
        postPresenter.getChat(map);
        adapterChat = new AdapterAllChatActivity(this, new ArrayList<DataItem>(), this);
        recyclerView.setAdapter(adapterChat);


    }

    @Override
    public void setChat(GetChatModel getChatModel) {
        adapterChat.addComment(getChatModel.getData());
    }

    @Override
    public void onCallBackChat(int userId) {
        Intent intent = new Intent(this, ActivityChatsMsg.class);
        intent.putExtra("userid", userId);
        startActivity(intent);
    }
}
