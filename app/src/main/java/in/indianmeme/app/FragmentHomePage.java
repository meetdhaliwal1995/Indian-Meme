package in.indianmeme.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterHome;
import in.indianmeme.app.Adapters.AdapterStory;
import in.indianmeme.app.ModelApi.AddLike.LikesUnlikeModel;
import in.indianmeme.app.ModelApi.AddStory.AddStoryUser;
import in.indianmeme.app.ModelApi.Delete.DeletePostModel;
import in.indianmeme.app.ModelApi.ExplorePosts.DatumExplore;
import in.indianmeme.app.ModelApi.ExplorePosts.PostExploreModel;
import in.indianmeme.app.ModelApi.Logout.LogoutUserModel;
import in.indianmeme.app.ModelApi.Story.StoryFetchModel;
import in.indianmeme.app.presenter.AddStoryPresenter;
import in.indianmeme.app.presenter.DeletePresenter;
import in.indianmeme.app.presenter.LikePresenter;
import in.indianmeme.app.presenter.LogoutPresenter;
import in.indianmeme.app.presenter.PostHomeExplorerPresenter;
import in.indianmeme.app.presenter.StoryPresenter;
import in.indianmeme.app.views.AddStroyContract;
import in.indianmeme.app.views.DeleteContract;
import in.indianmeme.app.views.LikeContract;
import in.indianmeme.app.views.LogoutContract;
import in.indianmeme.app.views.PostHomeExploreContract;
import in.indianmeme.app.views.StoryContract;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class FragmentHomePage extends Fragment implements PostHomeExploreContract.ExploreView,
        StoryContract.UserStoryView, LikeContract.LikeView,
        SwipeRefreshLayout.OnRefreshListener, LogoutContract.LogoutView,
        InterfaceAdapterHome, FragmentVideoView.VideoCallBack,
        DeleteContract.DelteView, AddStroyContract.AddStoryView {

    RecyclerView recyclerView, recyclerView1;
    ImageView home, myProfile, add, more, logout, addStory;
    FragmentUserHome fragmentUserHome;
    String postid;
    SwipeRefreshLayout swipeRefreshLayout;
    AdapterHome adapterHome;
    PostHomeExplorerPresenter homePagePresenter;
    Map<String, Object> map1;
    Map<String, Object> map;
    FragmentLoginUserHome fragmentLoginUserHome;
    LogoutPresenter logoutPresenter;
    DeletePresenter deletePresenter;
    LikePresenter likePresenter;
    StoryPresenter storyPresenter;
    FragmentVideoView fragmentVideoView;
    AddStoryPresenter addStoryPresenter;
    AdapterStory adapterStory;
    int videopos;
    int postPos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_2);
        recyclerView1 = view.findViewById(R.id.recycler_1);
        myProfile = view.findViewById(R.id.person_image);
        home = view.findViewById(R.id.home_imz);
        add = view.findViewById(R.id.add_image);
        more = view.findViewById(R.id.more_image);
        logout = view.findViewById(R.id.massanger_imz);
        addStory = view.findViewById(R.id.pixel_imz);
        swipeRefreshLayout = view.findViewById(R.id.scroll_refresh);

        swipeRefreshLayout.setOnRefreshListener(this);


        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterHome = new AdapterHome(getContext(), new ArrayList<>(), this);
        recyclerView.setAdapter(adapterHome);

        adapterStory = new AdapterStory(getContext(), new ArrayList<>());
        recyclerView1.setAdapter(adapterStory);

        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {
                Log.e("dddd", "aaaa");
            }

            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {
                Log.e("ddd", "bbb");
            }
        });

        homePagePresenter = new PostHomeExplorerPresenter(this);
        storyPresenter = new StoryPresenter(this);
        logoutPresenter = new LogoutPresenter(this);
        likePresenter = new LikePresenter(this);
        deletePresenter = new DeletePresenter(this);
        addStoryPresenter = new AddStoryPresenter(this);


        addStory.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("*/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constant.REQUEST_CODE_PICTURE);
        });
        logout.setOnClickListener(v -> {
            final Map<String, Object> map1 = new HashMap<>();
            map1.put("access_token", PrefUtils.getAccessToken());
            map1.put("server_key", Constant.SERVER_KEY);
            logoutPresenter.getData(map1);
            Toast.makeText(getContext(), "logout", Toast.LENGTH_SHORT).show();

        });


        map = new HashMap<>();
        map.put("access_token", PrefUtils.getAccessToken());
        map.put("server_key", Constant.SERVER_KEY);
        map.put("limit", 50);
        homePagePresenter.getData(map);
        storyPresenter.getData(map);

        map1 = new HashMap<>();
        map1.put("access_token", PrefUtils.getAccessToken());
        map1.put("server_key", Constant.SERVER_KEY);
        map1.put("post_id", postid);
        likePresenter.getData(map1);


    }

    @Override
    public void callBack(int userId) {
        if (userId == PrefUtils.getUserId()) {
            fragmentLoginUserHome = new FragmentLoginUserHome();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container_layout, fragmentLoginUserHome)
                    .addToBackStack("ddd")
                    .commit();
            Log.e("ddd", "dddd");
        } else {
            fragmentUserHome = new FragmentUserHome();
            fragmentUserHome.setid(userId);
            getFragmentManager().beginTransaction()
                    .replace(R.id.container_layout, fragmentUserHome)
                    .addToBackStack("fd")
                    .commit();
            Log.e("ddd", "ffff");

        }
    }

    @Override
    public void likeInterface(String postId) {
        postid = postId;
        Map<String, Object> mapLike = new HashMap<>();
        mapLike.put("server_key", Constant.SERVER_KEY);
        mapLike.put("access_token", PrefUtils.getAccessToken());
        mapLike.put("post_id", postId);
        likePresenter.getData(mapLike);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setLatestData(StoryFetchModel storyFetch) {
        Log.e("check","story add");
        if (!storyFetch.getData().isEmpty()) {
            adapterStory.addPost(storyFetch.getData());
            Log.e("checkk","story add");
        } else {
            recyclerView1.setVisibility(View.GONE);
        }
    }

    @Override
    public void setLatestData(PostExploreModel postExplore) {

        swipeRefreshLayout.setRefreshing(false);

        adapterHome.addPost(postExplore.getData());

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onRefresh() {
        adapterHome.clearPost();
        adapterStory.clearStory();
        storyPresenter.getData(map);
        homePagePresenter.getData(map);
    }

    @Override
    public void setLatestData(LikesUnlikeModel likesUnlike) {

    }

    @Override
    public void setLatestData(LogoutUserModel logoutUser) {
        PrefUtils.setAccessToken(null);
        Toast.makeText(getContext(), logoutUser.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ActivityLogin.class);
        startActivity(intent);

    }

    @Override
    public void callBackVideo(String file, int pos) {
        videopos = pos;

//        AdapterHome.ImageViewHolder holder = (AdapterHome.ImageViewHolder) recyclerView.findViewHolderForAdapterPosition(pos);

        fragmentVideoView = new FragmentVideoView();
        fragmentVideoView.setVideoView(file);
        fragmentVideoView.setVideoCallBack(this);
//        getFragmentManager().beginTransaction()
//                .add(viewHolder.container.getId(), fragmentVideoView)
//                .addToBackStack("ggg")
//                .commit();
    }

    @Override
    public void deletePost(Map<String, Object> map, int pos) {
        deletePresenter.getData(map);
        adapterHome.updateList(pos);

    }

    @Override
    public void videoCompleted() {
        getFragmentManager().beginTransaction()
                .remove(fragmentVideoView)
                .commit();
    }

    @Override
    public void setLatestData(DeletePostModel deletePost) {

        Toast.makeText(getContext(), deletePost.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constant.REQUEST_CODE_PICTURE) {
            Uri uri = data.getData();


            if (requestCode == Constant.REQUEST_CODE_PICTURE) {

//                if (uri.toString().contains("jpg")) {
                try {
                    String fileName = uri.getPath().split(":")[1];

                    InputStream is = getContext().getContentResolver().openInputStream(uri);
                    Bitmap bitmap = Constant.getScaledBitmap(BitmapFactory.decodeStream(is));
                    is.close();

                    File file = new File(getContext().getCacheDir() + File.separator + fileName + ".jpg");
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, os);
                    os.close();

                    Log.e("data", Constant.getPath(getContext(), data.getData()));
//                      RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
                    RequestBody requestBodyImage = RequestBody.create(MediaType.parse("*/*"), file);

                    MultipartBody.Part story = MultipartBody.Part.createFormData("file", file.getName(), requestBodyImage);
                    MultipartBody.Part server_key = MultipartBody.Part.createFormData("server_key", Constant.SERVER_KEY);
                    MultipartBody.Part access_token = MultipartBody.Part.createFormData("access_token", PrefUtils.getAccessToken());
                    MultipartBody.Part caption = MultipartBody.Part.createFormData("caption", "sd");
                    addStoryPresenter.getData(story, server_key, access_token);
                    Log.e("dddd", "image");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setLatestData(AddStoryUser addStoryUser) {

        Toast.makeText(getContext(), addStoryUser.getData().getMessage(), Toast.LENGTH_SHORT).show();

    }

    private void menuPopUp() {
        PopupMenu popupMenu = new PopupMenu(getContext(), logout);
    }
}
