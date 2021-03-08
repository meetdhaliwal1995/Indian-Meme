package in.indianmeme.app;

import android.app.Service;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterComment;
import in.indianmeme.app.ModelApi.AddComments.AddCommentModel;
import in.indianmeme.app.ModelApi.AddUserReply.AddReplyModel;
import in.indianmeme.app.ModelApi.Comments.CommentInfoModel;
import in.indianmeme.app.ModelApi.Comments.Datum;
import in.indianmeme.app.ModelApi.CommentsRply.FetchReplyModel;
import in.indianmeme.app.ModelApi.DlteCommt.DeleteCommentModel;
import in.indianmeme.app.presenter.PostPresenter;
import in.indianmeme.app.views.PostContract;


public class ActivityComments extends AppCompatActivity implements
        SwipeRefreshLayout.OnRefreshListener, InterfaceComment,
        PostContract.PostView {

    ImageView back, profile;
    EditText comment, post;
    TextView postAddCmt;
    RecyclerView recyclerView;
    AdapterComment adapterComment;
    SwipeRefreshLayout swipeRefreshLayout;
    Map<String, Object> map;
    FragmentHomePage fragmentHomePage;
    PostPresenter postPresenter;

    int adpos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        back = findViewById(R.id.back_imz_comment);
        comment = findViewById(R.id.comment_edit);
        profile = findViewById(R.id.fetch_comment_imz);
        comment = findViewById(R.id.comment_edit);
        postAddCmt = findViewById(R.id.post_text);
        recyclerView = findViewById(R.id.comment_recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setOnRefreshListener(this);

        initCommentAdapter();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dddd", "ggggg");
                fragmentHomePage = new FragmentHomePage();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragmentHomePage)
                        .commit();

                Log.e("dddd", "dgddd");
            }
        });

        postPresenter = new PostPresenter(this);

        final String post_id = String.valueOf(getIntent().getStringExtra("post_id"));

        Glide.with(this).load(PrefUtils.getAvatar()).circleCrop().into(profile);


        map = new HashMap<>();
        map.put("access_token", PrefUtils.getAccessToken());
        map.put("server_key", Constant.SERVER_KEY);
        map.put("post_id", post_id);
//        commentsPresenter.getData(map);
        postPresenter.getUserComment(map);

        postAddCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, Object> map1 = new HashMap<>();
                map1.put("access_token", PrefUtils.getAccessToken());
                map1.put("server_key", Constant.SERVER_KEY);
                map1.put("post_id", post_id);
                map1.put("text", comment.getText().toString());
                postPresenter.getAddComment(map1);
                comment.setText("");
            }
        });
    }

    private void initCommentAdapter() {
        if (adapterComment != null) {
            adapterComment.clearComments();
            recyclerView.setAdapter(null);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterComment = new AdapterComment(this, new ArrayList<Datum>(), this);
        recyclerView.setAdapter(adapterComment);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void setAddComment(AddCommentModel addCommentModel) {
        adapterComment.addComment(addCommentModel.getData());
    }


    @Override
    public void setUserComment(CommentInfoModel commentInfo) {
        swipeRefreshLayout.setRefreshing(false);
        adapterComment.addComment(commentInfo.getData());
    }

//    @Override
//    public void showError(String error) {
//
//    }

    @Override
    public void onRefresh() {
        initCommentAdapter();
        postPresenter.getUserComment(map);
    }

    @Override
    public void callBackRply(int commentId, int pos) {
        adpos = pos;
        Map<String, Object> map1 = new HashMap<>();
        map1.put("access_token", PrefUtils.getAccessToken());
        map1.put("server_key", Constant.SERVER_KEY);
        map1.put("comment_id", commentId);
        postPresenter.getFetchReply(map1);
    }


    @Override
    public void setFetchReply(FetchReplyModel fetchReplyModel) {
        AdapterComment.CommentViewHolder commentViewHolder =
                (AdapterComment.CommentViewHolder) recyclerView.findViewHolderForAdapterPosition(adpos);

        commentViewHolder.setReplyData(fetchReplyModel);
    }

    @Override
    public void callUserReply(final int commentId) {
        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(comment, 0);
        comment.requestFocus();
        postAddCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> addreply = new HashMap<>();
                addreply.put("access_token", PrefUtils.getAccessToken());
                addreply.put("server_key", Constant.SERVER_KEY);
                addreply.put("comment_id", commentId);
                addreply.put("text", comment.getText().toString());
//                addRplyPresenter.getData(addreply);
                postPresenter.getAddReply(addreply);

                inputMethodManager.hideSoftInputFromWindow(comment.getWindowToken(), 0);
                comment.clearFocus();
                comment.setText("");
            }
        });

    }


    @Override
    public void deleteComment(Map<String, Object> map, int adapterPosition) {
        postPresenter.getDeleteComment(map);
        adapterComment.updateList(adapterPosition);

    }

    @Override
    public void deleteReply(Map<String, Object> map, int adapterPosition) {
        postPresenter.getDeleteReply(map);
    }


    @Override
    public void setAddReply(AddReplyModel addReplyModel) {
        initCommentAdapter();
//        commentsPresenter.getData(map);
        postPresenter.getUserComment(map);
    }

    @Override
    public void setDeleteCommentData(DeleteCommentModel deleteComment) {
        Toast.makeText(getApplicationContext(), "Comment Delete", Toast.LENGTH_SHORT).show();
    }
}
