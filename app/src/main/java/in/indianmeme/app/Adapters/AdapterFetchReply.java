package in.indianmeme.app.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.indianmeme.app.Constant;
import in.indianmeme.app.ModelApi.CommentsRply.FetchRplyList;
import in.indianmeme.app.PrefUtils;
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

    public void updateListReply(int pos) {
        _list.remove(pos);
        notifyItemRemoved(pos);
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

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    if (_list.get(getAdapterPosition()).getUserId() == PrefUtils.getUserId()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setCancelable(true);
                        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
                        View view2 = layoutInflaterAndroid.inflate(R.layout.dialog_delete_layout, null);
                        builder.setView(view2);
                        final AlertDialog alertDialog = builder.create();
                        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        alertDialog.show();
                        TextView delete, copy;
                        copy = view2.findViewById(R.id.copy);
                        delete = view2.findViewById(R.id.delete2);
                        delete.setOnClickListener(v1 -> {
                            Map<String, Object> map = new HashMap<>();
                            map.put("server_key", Constant.SERVER_KEY);
                            map.put("access_token", PrefUtils.getAccessToken());
                            map.put("reply_id", _list.get(getAdapterPosition()).getId());
                            updateListReply(getAdapterPosition());
                            alertDialog.dismiss();
                        });
                    } else {

                    }
                    return false;
                }
            });


        }
    }
}
