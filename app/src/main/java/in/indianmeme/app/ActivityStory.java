package in.indianmeme.app;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.indianmeme.app.ModelApi.Story.Datum;
import in.indianmeme.app.ModelApi.Story.Story;
import jp.shts.android.storiesprogressview.StoriesProgressView;

public class ActivityStory extends AppCompatActivity implements StoriesProgressView.StoriesListener {
    ImageView image;
    StoriesProgressView storiesProgressView;

    private static final int PROGRESS_COUNT = 6;
    private int counter = 0;

    long pressTime = 0L;
    long limit = 500L;
    List<Story> stories;

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressTime = System.currentTimeMillis();
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:
                    long now = System.currentTimeMillis();
                    storiesProgressView.resume();
                    return limit < now - pressTime;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        image = findViewById(R.id.story_imz);

        int clickedStory = getIntent().getIntExtra("pos", 0);
        ArrayList<Datum> listStory = getIntent().getParcelableArrayListExtra("story");

        stories = listStory.get(0).getStories();
        Log.e("story", String.valueOf(stories.size()));

        storiesProgressView = findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(stories.size());
        storiesProgressView.setStoryDuration(3000L);
        storiesProgressView.setStoriesListener(this);
        counter = clickedStory;
        storiesProgressView.startStories(counter);
        Glide.with(getApplicationContext()).load(stories.get(counter).getMediaFile()).into(image);
        Log.e("size", String.valueOf(stories.size()));

        View reverse = findViewById(R.id.reverse);
        reverse.setOnClickListener(v -> storiesProgressView.reverse());
        reverse.setOnTouchListener(onTouchListener);

        View skip = findViewById(R.id.skip);
        skip.setOnClickListener(v -> storiesProgressView.skip());
        skip.setOnTouchListener(onTouchListener);
    }

    @Override
    public void onNext() {
        counter++;
        Glide.with(getApplicationContext()).load(stories.get(counter).getMediaFile()).into(image);
        Log.e("nxt","btn");
    }

    @Override
    public void onPrev() {
        if ((counter - 1) < 0) return;
        --counter;
        Glide.with(getApplicationContext()).load(stories.get(counter).getMediaFile()).into(image);
        Log.e("pre","btn");
    }

    @Override
    public void onComplete() {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        // Very important !
        storiesProgressView.destroy();
        super.onDestroy();
    }
}