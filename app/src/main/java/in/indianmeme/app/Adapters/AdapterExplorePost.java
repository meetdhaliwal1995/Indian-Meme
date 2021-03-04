package in.indianmeme.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.indianmeme.app.ModelApi.ExplorePosts.DatumExplore;
import in.indianmeme.app.R;

public class AdapterExplorePost extends RecyclerView.Adapter<AdapterExplorePost.ExploreViewHolder> {

    private Context context;
    private List<DatumExplore> _list;

    public AdapterExplorePost(Context context, List<DatumExplore> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public AdapterExplorePost.ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.explore_recyclerview, parent, false);
        return new ExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExplorePost.ExploreViewHolder holder, int position) {
        DatumExplore datumExplore = _list.get(position);
        Glide.with(context)
                .load(datumExplore.getMediaSet().get(0).getFile())
                .into(holder.imz);

    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder {
        ImageView imz;

        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            imz = itemView.findViewById(R.id.explore_imz);
        }
    }
}
