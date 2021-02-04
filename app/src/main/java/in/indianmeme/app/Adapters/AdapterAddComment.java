package in.indianmeme.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.indianmeme.app.ModelApi.AddComments.Datum;
import in.indianmeme.app.R;

public class AdapterAddComment extends RecyclerView.Adapter<AdapterAddComment.ViewHolder> {

    private Context context;
    private List<Datum> _list;

    public AdapterAddComment(Context context, List<Datum> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum datumA = _list.get(position);

        Glide.with(context).load(datumA.getAvatar()).circleCrop().into(holder.userImage);
        holder.userName.setText(datumA.getUsername());
        holder.userComment.setText(datumA.getText());


    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userComment, userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userComment = itemView.findViewById(R.id.user_comment_text);
            userImage = itemView.findViewById(R.id.user_comment_imz);
            userName = itemView.findViewById(R.id.username_comment);

        }
    }
}
