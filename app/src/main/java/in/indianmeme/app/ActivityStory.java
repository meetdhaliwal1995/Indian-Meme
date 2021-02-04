package in.indianmeme.app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class ActivityStory extends AppCompatActivity implements StoriesProgressView.StoriesListener {
    ImageView image;
    SeekBar seekBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        image = findViewById(R.id.story_imz);
        seekBar = findViewById(R.id.seek_bar);


        String intent = getIntent().getStringExtra("story");
        Glide.with(getApplicationContext()).load(intent).into(image);


    }

    @Override
    public void onNext() {

    }

    @Override
    public void onPrev() {

    }

    @Override
    public void onComplete() {

    }
}
