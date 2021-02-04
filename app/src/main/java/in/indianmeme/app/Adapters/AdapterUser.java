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

import in.indianmeme.app.ModelApi.ProfileModel.UserPost;
import in.indianmeme.app.R;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    private Context context;
    private List<UserPost> _list;

    public AdapterUser(Context context, List<UserPost> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_user_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserPost data = _list.get(position);

//        holder.storyText.setText(data.getUserData().getName());
//        Glide.with(context).load(data.getAvatar())
//                .centerCrop()
//                .into()
        Glide.with(context).load(data.getMediaSet().get(0).getFile()).into(holder.userpostImz);
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userpostImz;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userpostImz = itemView.findViewById(R.id.user_recycler_imz);
        }
    }
}
