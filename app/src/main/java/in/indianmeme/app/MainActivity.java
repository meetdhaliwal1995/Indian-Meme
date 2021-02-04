package in.indianmeme.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterHome;
import in.indianmeme.app.Adapters.AdapterStory;
import in.indianmeme.app.ModelApi.ExplorePosts.PostExplore;
import in.indianmeme.app.ModelApi.Logout.LogoutUser;
import in.indianmeme.app.ModelApi.Story.StoryFetch;
import in.indianmeme.app.presenter.LogoutPresenter;
import in.indianmeme.app.presenter.PostHomeExplorerPresenter;
import in.indianmeme.app.presenter.StoryPresenter;
import in.indianmeme.app.views.LogoutContract;
import in.indianmeme.app.views.PostHomeExploreContract;
import in.indianmeme.app.views.StoryContract;

public class MainActivity extends AppCompatActivity implements PostHomeExploreContract.ExploreView, StoryContract.UserStoryView, InterfaceContent, LogoutContract.LogoutView {

    RecyclerView recyclerView, recyclerView1;
    ImageView home, myProfile, add, more, massanger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_2);
        recyclerView1 = findViewById(R.id.recycler_1);
        myProfile = findViewById(R.id.person_image);
        home = findViewById(R.id.home_imz);
        add = findViewById(R.id.add_image);
        more = findViewById(R.id.more_image);
        massanger = findViewById(R.id.massanger_imz);


        final String access_token = PrefUtils.getAccessToken();
        final String server_key = Constant.SERVER_KEY;
        final String user_id = String.valueOf(PrefUtils.getUserId());

        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PostHomeExplorerPresenter homePagePresenter = new PostHomeExplorerPresenter(this);
        StoryPresenter storyPresenter = new StoryPresenter(this);
        final LogoutPresenter logoutPresenter = new LogoutPresenter(this);


        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("server_key", server_key);
        map.put("limit", 50);
        homePagePresenter.getData(map);
        storyPresenter.getData(map);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityUserHome.class);
                intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        });

        massanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, Object> map1 = new HashMap<>();
                map1.put("access_token", access_token);
                map1.put("server_key", server_key);
                logoutPresenter.getData(map1);
                Toast.makeText(getApplicationContext(), "logout", Toast.LENGTH_SHORT).show();

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
    public void setLatestData(StoryFetch storyFetch) {
        AdapterStory adapterStory = new AdapterStory(this, storyFetch.getData());
        recyclerView1.setAdapter(adapterStory);
    }

    @Override
    public void setLatestData(PostExplore postExplore) {
        AdapterHome adapterHome = new AdapterHome(this, postExplore.getData(), this);
        recyclerView.setAdapter(adapterHome);
    }


    @Override
    public void showError(String error) {

    }


    @Override
    public void callBack(String getId) {
        Intent intent = new Intent(MainActivity.this, ActivityUserHome.class);
        intent.putExtra("getUserId", getId);
        startActivity(intent);
    }

    private void menuPopup() {

        PopupMenu popupMenu = new PopupMenu(this, more);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.memu_1:


                }
                return false;
            }
        });

        popupMenu.show();
    }

    @Override
    public void setLatestData(LogoutUser logoutUser) {
        Log.e("ddd", "ggg");

        PrefUtils.setAccessToken(null);
        Toast.makeText(getApplicationContext(), logoutUser.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
        startActivity(intent);


    }
}