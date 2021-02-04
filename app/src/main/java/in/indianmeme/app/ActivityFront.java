package in.indianmeme.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityFront extends AppCompatActivity {

    ViewPager viewPager;
    List<ModelClass> _list = new ArrayList<>();
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        viewPager = findViewById(R.id.view_pager);
        textView = findViewById(R.id.btn_sign);

        String title = "Like and follow";
        String name = "Just Like the photos which you found \n intresting.And become a follower of famous \n people in your area";

        ModelClass frag1 = new ModelClass(title, name);
        _list.add(frag1);

        String title1 = "Save and favorite";
        String name1 = "Immediately Save Images or video to check \n them later anytime";

        ModelClass frag2 = new ModelClass(title1, name1);
        _list.add(frag2);


        SlidePagerAdapter slidePagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), FragmentManager.POP_BACK_STACK_INCLUSIVE, _list);
        viewPager.setAdapter(slidePagerAdapter);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityFront.this, ActivityRegister.class);
                startActivity(intent);
            }
        });
    }
}
