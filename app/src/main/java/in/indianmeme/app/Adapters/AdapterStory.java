package in.indianmeme.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.indianmeme.app.ActivityStory;
import in.indianmeme.app.ModelApi.Story.Datum;
import in.indianmeme.app.R;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.ViewHolder> {

    private Context context;
    private List<Datum> _list;

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
        Datum data = _list.get(position);

        holder.storyText.setText(data.getUsername().substring(0, 6));
        Glide.with(context).load(data.getAvatar()).circleCrop().into(holder.storyImz);
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView storyImz;
        TextView storyText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storyImz = itemView.findViewById(R.id.image_story);
            storyText = itemView.findViewById(R.id.story_name);

            storyImz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent story = new Intent(context, ActivityStory.class);
                    story.putExtra("story", _list.get(getAdapterPosition()).getMediaFile());
                    context.startActivity(story);
                }
            });
        }
    }
}
