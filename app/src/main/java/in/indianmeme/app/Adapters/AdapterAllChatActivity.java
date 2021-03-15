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

import in.indianmeme.app.ModelApi.GetChat.DataItem;
import in.indianmeme.app.R;

public class AdapterAllChatActivity extends RecyclerView.Adapter<AdapterAllChatActivity.ViewHolder> {

    private Context context;
    private List<DataItem> _list;
    private AdapterCallChat adapterCallChat;

    public AdapterAllChatActivity(Context context, List<DataItem> _list, AdapterCallChat adapterCallChat) {
        this.context = context;
        this._list = _list;
        this.adapterCallChat = adapterCallChat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_getchat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataItem item = _list.get(position);

        holder.username.setText(item.getUsername());
        Glide.with(context).load(item.getAvatar())
                .circleCrop()
                .into(holder.userImz);
        holder.userlastmsg.setText(item.getLastMessage());
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public void addComment(List<DataItem> _data) {
        _list.addAll(_data);
        notifyDataSetChanged();
    }

    public interface AdapterCallChat {
        void onCallBackChat(int userId);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImz;
        TextView username, userlastmsg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImz = itemView.findViewById(R.id.user_dp);
            userlastmsg = itemView.findViewById(R.id.user_lastmsg);
            username = itemView.findViewById(R.id.user_namegetChat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterCallChat.onCallBackChat(_list.get(getAdapterPosition()).getUserId());
                }
            });
        }
    }
}
