package in.indianmeme.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterExplorePost;
import in.indianmeme.app.ModelApi.ExplorePosts.PostExploreModel;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;

public class FragmentExplorePost extends Fragment implements PostContract.PostView {

    RecyclerView recyclerView;
    Map<String, Object> mapExplore;
    AdapterExplorePost adapterExplorePost;
    PostPresenter postPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_explore_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_explore);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
//        postExplorePresenter = new PostExplorePresenter(this);
        postPresenter = new PostPresenter(this);

        mapExplore = new HashMap<>();
        mapExplore.put("access_token", PrefUtils.getAccessToken());
        mapExplore.put("server_key", Constant.SERVER_KEY);
        mapExplore.put("limit", 50);
//        postExplorePresenter.getData(mapExplore);
        postPresenter.getPostExplore(mapExplore);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

//    @Override
//    public void setLatestData(PostExploreModel postExplore) {
//        adapterExplorePost = new AdapterExplorePost(getContext(), postExplore.getData());
//        recyclerView.setAdapter(adapterExplorePost);
//    }

    @Override
    public void setPostExplore(PostExploreModel postExplore) {
        adapterExplorePost = new AdapterExplorePost(getContext(), postExplore.getData());
        recyclerView.setAdapter(adapterExplorePost);
    }

    @Override
    public void showError(String error) {

    }
}
