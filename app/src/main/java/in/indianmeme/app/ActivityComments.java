package in.indianmeme.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.Adapters.AdapterAddComment;
import in.indianmeme.app.Adapters.AdapterComment;
import in.indianmeme.app.ModelApi.AddComments.AddComment;
import in.indianmeme.app.ModelApi.Comments.CommentInfo;
import in.indianmeme.app.presenter.AddCommentsPresenter;
import in.indianmeme.app.presenter.CommentsPresenter;
import in.indianmeme.app.views.AddCommentContract;
import in.indianmeme.app.views.UserCommentContract;

public class ActivityComments extends AppCompatActivity implements UserCommentContract.UserCommentView, AddCommentContract.AddCommentView {

    ImageView back, profile;
    EditText comment, post;
    TextView posttext;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        back = findViewById(R.id.back_imz_comment);
        profile = findViewById(R.id.user_comment_imz);
        comment = findViewById(R.id.comment_edit);
        post = findViewById(R.id.edit_post);
        posttext = findViewById(R.id.post_text);
        recyclerView = findViewById(R.id.comment_recyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CommentsPresenter commentsPresenter = new CommentsPresenter(this);
        final AddCommentsPresenter addCommentsPresenter = new AddCommentsPresenter(this);

        final String post_id = String.valueOf(getIntent().getStringExtra("post_id"));
        final String access_token = PrefUtils.getAccessToken();
        final String server_key = Constant.SERVER_KEY;
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", access_token);
        map.put("server_key", server_key);
        map.put("post_id", post_id);
        commentsPresenter.getData(map);


        posttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String dd = comment.getText().toString();
                Log.e("ddd", "dddd");
                final Map<String, Object> map1 = new HashMap<>();
                map1.put("access_token", access_token);
                map1.put("server_key", server_key);
                map1.put("post_id", post_id);
                map1.put("text", dd);
                addCommentsPresenter.getData(map1);

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
    public void setLatestData(AddComment addComment) {
        Glide.with(getApplicationContext()).load(addComment.getData().get(0).getAvatar()).circleCrop().into(profile);
        AdapterAddComment adapterAddComment = new AdapterAddComment(getApplicationContext(), addComment.getData());
        recyclerView.setAdapter(adapterAddComment);
    }

    @Override
    public void setLatestData(CommentInfo commentInfo) {
        Glide.with(getApplicationContext()).load(commentInfo.getData().get(0).getAvatar()).circleCrop().into(profile);
        AdapterComment adapterComment = new AdapterComment(getApplicationContext(), commentInfo.getData());
        recyclerView.setAdapter(adapterComment);
    }

    @Override
    public void showError(String error) {

    }
}
