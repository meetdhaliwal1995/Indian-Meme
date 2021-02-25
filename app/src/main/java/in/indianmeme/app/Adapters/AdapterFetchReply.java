package in.indianmeme.app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.indianmeme.app.Constant;
import in.indianmeme.app.ModelApi.CommentsRply.FetchRplyList;
import in.indianmeme.app.R;

public class AdapterFetchReply extends RecyclerView.Adapter<AdapterFetchReply.ViewHolder> {

    private final Context context;
    private final List<FetchRplyList> _list;

    public AdapterFetchReply(Context context, List<FetchRplyList> _list) {
        this.context = context;
        this._list = _list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fetch_reply_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FetchRplyList listadd = _list.get(position);
        Glide.with(context).load(Constant.BASR_URL + listadd.getAvatar()).circleCrop().into(holder.userImage);
        holder.userName.setText(listadd.getUsername());
        holder.userRply.setText(listadd.getText());
        holder.timefetch.setText(listadd.getTextTime());
        String dd = listadd.getTime();
        long lll = Long.parseLong(dd);
        String str = String.valueOf(lll);
//        holder.timefetch.setText(Constant.ChangeTimeFormet(str));
    }

    @Override
    public int getItemCount() {

        return _list.size();
    }

    public void addComment(List<FetchRplyList> _data) {
        _list.addAll(_data);
        notifyDataSetChanged();
    }

    public void clearComment() {
        _list.clear();
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userRply, userName, timefetch;
        EditText rplyEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userRply = itemView.findViewById(R.id.user_fetch_rply_cmt);
            userImage = itemView.findViewById(R.id.fetch_comment_imz);
            userName = itemView.findViewById(R.id.username_fetch_rply);
            timefetch = itemView.findViewById(R.id.text_time);

        }
    }
}
