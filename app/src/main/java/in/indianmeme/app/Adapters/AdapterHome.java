package in.indianmeme.app.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import in.indianmeme.app.ActivityComments;
import in.indianmeme.app.InterfaceContent;
import in.indianmeme.app.ModelApi.ExplorePosts.DatumExplore;
import in.indianmeme.app.R;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    private Context context;
    private List<DatumExplore> _list;
    private InterfaceContent interfaceContent;
    boolean click = true;
    boolean isClicked;


    public AdapterHome(Context context, List<DatumExplore> _list, InterfaceContent interfaceContent) {
        this.context = context;
        this._list = _list;
        this.interfaceContent = interfaceContent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DatumExplore data = _list.get(position);

        holder.userName.setText(data.getUsername());
        Glide.with(context).load(data.getMediaSet().get(0).getFile())
                .into(holder.userImz);
        Glide.with(context)
                .load(data.getAvatar())
                .circleCrop()
                .into(holder.userProfile);

        holder.likes.setText(String.valueOf(data.getLikes()));
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userImz, userProfile, comment, likeimz, more;
        TextView userName, likes;
        ConstraintLayout hiddenpanel, parent;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            userImz = itemView.findViewById(R.id.user_image);
            userProfile = itemView.findViewById(R.id.image_userprofile);
            userName = itemView.findViewById(R.id.user_name);
            likes = itemView.findViewById(R.id.like_int);
            comment = itemView.findViewById(R.id.comment_image);
            likeimz = itemView.findViewById(R.id.like_image);
            more = itemView.findViewById(R.id.more_image);

            parent = itemView.findViewById(R.id.parent_layout);

//            userName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, ActivityUserAllInfo.class);
//                    intent.putExtra("getUserId", String.valueOf(_list.get(getAdapterPosition()).getUserId()));
//
//                    context.startActivity(intent);
//                }
//            });
            likeimz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (click) {
                        click = false;
                        likeimz.setImageResource(R.drawable.ic_baseline_favorite_fill);
                    } else {
                        click = true;
                        likeimz.setImageResource(R.drawable.ic_baseline_favorite_notfill);
                    }

                }
            });

            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent comment = new Intent(context, ActivityComments.class);
                    comment.putExtra("post_id", String.valueOf(_list.get(getAdapterPosition()).getPostId()));
                    context.startActivity(comment);
                }
            });

            userName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interfaceContent.callBack(String.valueOf(_list.get(getAdapterPosition()).getUserId()));
                }
            });

            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setCancelable(true);
                    LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
                    View view2 = layoutInflaterAndroid.inflate(R.layout.dialog_layout, null);
                    builder.setView(view2);
                    final AlertDialog alertDialog = builder.create();
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    alertDialog.show();

                }
            });
        }
    }
}
