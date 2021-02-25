package in.indianmeme.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.indianmeme.app.ActivityStory;
import in.indianmeme.app.ModelApi.Story.Datum;
import in.indianmeme.app.ModelApi.Story.Story;
import in.indianmeme.app.R;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.ViewHolder> {

    private final Context context;
    private final List<Datum> _list;

    public AdapterStory(Context context, List<Datum> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum datum = _list.get(0);

        holder.storyText.setText(datum.getUsername().substring(0, 4));
        Glide.with(context).load(datum.getAvatar()).circleCrop().into(holder.storyImz);
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }


    public void addPost(List<Datum> _data) {
        _list.addAll(_data);
        notifyDataSetChanged();
    }

    public void clearStory() {
        _list.clear();
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView storyImz;
        TextView storyText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storyImz = itemView.findViewById(R.id.image_story);
            storyText = itemView.findViewById(R.id.story_name);

            storyImz.setOnClickListener(v -> {
                Log.e("size list", String.valueOf(_list.get(0).getStories().size()));
                Intent story = new Intent(context, ActivityStory.class);
                story.putExtra("pos", getAdapterPosition());
                story.putParcelableArrayListExtra("story", new ArrayList<>(_list));
                context.startActivity(story);
            });
        }
    }
}
