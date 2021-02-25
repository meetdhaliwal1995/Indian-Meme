package in.indianmeme.app.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.indianmeme.app.InterfaceComment;
import in.indianmeme.app.ModelApi.Comments.Datum;
import in.indianmeme.app.ModelApi.CommentsRply.FetchReplyModel;
import in.indianmeme.app.ModelApi.CommentsRply.FetchRplyList;
import in.indianmeme.app.R;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.CommentViewHolder> {

    private final Context context;
    private final List<Datum> _list;
    private final InterfaceComment interfaceContent;

    public AdapterComment(Context context, List<Datum> _list, InterfaceComment interfaceContent) {
        this.context = context;
        this._list = _list;
        this.interfaceContent = interfaceContent;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_recycler, parent, false);
        return new CommentViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Datum datum = _list.get(position);
        Glide.with(context).load(datum.getAvatar()).circleCrop().into(holder.userImage);
        holder.userName.setText(datum.getUsername() + " :");
        holder.userComment.setText(datum.getText());
        String valv = String.valueOf(datum.getReplies());
        holder.replynumber.setText(valv);
        holder.time.setText(datum.getTimeText());
        if (datum.getReplies() == 0) {
            holder.replynumber.setVisibility(View.GONE);
            holder.replytext.setVisibility(View.GONE);

        } else {
            holder.replynumber.setVisibility(View.VISIBLE);
            holder.replytext.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public void addComment(List<Datum> _data) {
        _list.addAll(_data);
        notifyDataSetChanged();
    }

    public void clearComments() {
        _list.clear();
        notifyDataSetChanged();
    }

    interface CallBack {

    }


    public class CommentViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userComment, userName, replytext, replynumber, time, rplyBtn;
        RecyclerView recyclerViewRply;
        AdapterFetchReply adapterReply;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            userComment = itemView.findViewById(R.id.user_fetch_rply_cmt);
            userImage = itemView.findViewById(R.id.fetch_comment_imz);
            userName = itemView.findViewById(R.id.username_fetch_rply);
            recyclerViewRply = itemView.findViewById(R.id.recycler_reply);
            replytext = itemView.findViewById(R.id.reply_text);
            replynumber = itemView.findViewById(R.id.reply_int);
            time = itemView.findViewById(R.id.text_time);
            rplyBtn = itemView.findViewById(R.id.user_rply_btn);
            recyclerViewRply.setLayoutManager(new LinearLayoutManager(context));
            adapterReply = new AdapterFetchReply(context, new ArrayList<FetchRplyList>());
            recyclerViewRply.setAdapter(adapterReply);


            replytext.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    if (recyclerViewRply.getVisibility() == View.GONE && _list.get(getAdapterPosition()).getReplies() != 0) {
                        recyclerViewRply.setVisibility(View.VISIBLE);
                        interfaceContent.callBackRply(_list.get(getAdapterPosition()).getId(), getAdapterPosition());
                        replytext.setText("hide reply :");
                    } else {
                        recyclerViewRply.setVisibility(View.GONE);
                        replytext.setText("view reply :");
                    }
                }
            });

            rplyBtn.setOnClickListener(v -> interfaceContent.callUserReply(_list.get(getAdapterPosition()).getId()));

        }

        public void setReplyData(FetchReplyModel fetchReplyModel) {
            adapterReply.clearComment();
            adapterReply.addComment(fetchReplyModel.getData());
        }
    }
}
