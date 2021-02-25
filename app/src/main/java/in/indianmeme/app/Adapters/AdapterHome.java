package in.indianmeme.app.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.indianmeme.app.ActivityComments;
import in.indianmeme.app.Constant;
import in.indianmeme.app.InterfaceAdapterHome;
import in.indianmeme.app.ModelApi.ExplorePosts.DatumExplore;
import in.indianmeme.app.PrefUtils;
import in.indianmeme.app.R;

public class AdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<DatumExplore> _list;
    private final InterfaceAdapterHome interfaceAdapterHome;
    private final int IMAGE_VIEW = 0;
    private final int VIDEO_VIEW = 1;

    public AdapterHome(Context context, List<DatumExplore> _list, InterfaceAdapterHome interfaceAdapterHome) {
        this.context = context;
        this._list = _list;
        this.interfaceAdapterHome = interfaceAdapterHome;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == IMAGE_VIEW) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_view2, parent, false);
            return new ImageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_view2copy, parent, false);
            return new VideoViewHolder(view);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DatumExplore data = _list.get(position);

        if (data.getType().equals("image")) {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;

            imageViewHolder.userName.setText(data.getUsername());

            Glide.with(context)
                    .load(data.getMediaSet().get(0).getFile())
                    .into(imageViewHolder.userImz);


            Glide.with(context)
                    .load(data.getAvatar())
                    .circleCrop()
                    .into(imageViewHolder.userProfile);

            imageViewHolder.likes.setText(String.valueOf(data.getLikes()));
            imageViewHolder.timepost.setText(data.getTimeText());
        } else {
            VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
            videoViewHolder.userName.setText(data.getUsername());


            if (data.getType().equals("video")) {
                videoViewHolder.play.setVisibility(View.VISIBLE);
            } else {
                videoViewHolder.play.setVisibility(View.GONE);
            }

            Glide.with(context)
                    .load(data.getMediaSet().get(0).getExtra())
                    .into(videoViewHolder.userImage);


            videoViewHolder.views.setText("views : " + data.getViews());

            Glide.with(context)
                    .load(data.getAvatar())
                    .circleCrop()
                    .into(videoViewHolder.userProfile);

            videoViewHolder.likes.setText(String.valueOf(data.getLikes()));
            videoViewHolder.timepost.setText(data.getTimeText());
        }
    }

    @Override
    public int getItemViewType(int position) {
        DatumExplore data = _list.get(position);

        if (data.getType().equals("image")) {
            return IMAGE_VIEW;
        } else {
            return VIDEO_VIEW;
        }
    }

    @Override
    public int getItemCount() {
        return _list.size();
    }

    public void addPost(List<DatumExplore> _data) {
        _list.addAll(_data);
        notifyDataSetChanged();
    }

    public void clearPost() {
        _list.clear();
        notifyDataSetChanged();
    }

    public void updateList(int pos) {
        _list.remove(pos);
        notifyDataSetChanged();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout container;
        ImageView userImz, userProfile, comment, likeimz, more, play;
        TextView userName, likes, timepost;

        public ImageViewHolder(@NonNull final View itemView) {
            super(itemView);
            userImz = itemView.findViewById(R.id.user_image);
            userProfile = itemView.findViewById(R.id.image_userprofile);
            userName = itemView.findViewById(R.id.user_name);
            likes = itemView.findViewById(R.id.like_int);
            comment = itemView.findViewById(R.id.comment_image);
            likeimz = itemView.findViewById(R.id.like_image);
            more = itemView.findViewById(R.id.more_image);
            timepost = itemView.findViewById(R.id.user_post_time);
            play = itemView.findViewById(R.id.play_btn);

            likeimz.setOnClickListener(v -> {

                boolean is_liked = _list.get(getAdapterPosition()).getIsLiked();

                if (!is_liked) {
                    _list.get(getAdapterPosition()).setIsLiked(true);
                    likeimz.setImageResource(R.drawable.ic_baseline_favorite_fill);
                    int countlike = Integer.parseInt(likes.getText().toString()) + 1;

                    Snackbar.make(likes, "Pic liked", Snackbar.LENGTH_SHORT).show();
                    likes.setText(String.valueOf(countlike));
                    interfaceAdapterHome.likeInterface(String.valueOf(_list.get(getAdapterPosition()).getPostId()));
                    Log.e("liked", "dddd");

                } else {
                    _list.get(getAdapterPosition()).setIsLiked(false);
                    likeimz.setImageResource(R.drawable.ic_baseline_favorite_notfill);
                    int countlike = Integer.parseInt(likes.getText().toString()) - 1;
                    Snackbar.make(likes, "Pic unliked", Snackbar.LENGTH_SHORT).show();

                    likes.setText(String.valueOf(countlike));
                    Log.e("unliked", "dddd");

                }
            });

            comment.setOnClickListener(v -> {
                Intent comment = new Intent(context, ActivityComments.class);
                comment.putExtra("post_id", String.valueOf(_list.get(getAdapterPosition()).getPostId()));
                context.startActivity(comment);
            });

            userName.setOnClickListener(v -> interfaceAdapterHome.callBack(_list.get(getAdapterPosition()).getUserId()));

            more.setOnClickListener(v -> {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
                View view2 = layoutInflaterAndroid.inflate(R.layout.dialog_layout, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                alertDialog.show();
                TextView delete;
                delete = view2.findViewById(R.id.delete);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("delte", "post");
                        Map<String, Object> map = new HashMap<>();
                        map.put("server_key", Constant.SERVER_KEY);
                        map.put("access_token", PrefUtils.getAccessToken());
                        map.put("post_id", _list.get(getAdapterPosition()).getPostId());
                        Log.e("delte", "post");
                        interfaceAdapterHome.deletePost(map, getAdapterPosition());
                        Log.e("delte", "postt");
                        alertDialog.dismiss();
                    }
                });
            });
        }

    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        ImageView userProfile, comment, likeimz, more, play, userImage;
        TextView userName, likes, timepost, views;
        VideoView videoView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            userProfile = itemView.findViewById(R.id.image_userprofile);
            userName = itemView.findViewById(R.id.user_name);
            likes = itemView.findViewById(R.id.like_int);
            comment = itemView.findViewById(R.id.comment_image);
            likeimz = itemView.findViewById(R.id.like_image);
            more = itemView.findViewById(R.id.more_image);
            timepost = itemView.findViewById(R.id.user_post_time);
            play = itemView.findViewById(R.id.play_btn);
            videoView = itemView.findViewById(R.id.view_video);
            userImage = itemView.findViewById(R.id.user_image);
            views = itemView.findViewById(R.id.views);

            likeimz.setOnClickListener(v -> {

                boolean is_liked = _list.get(getAdapterPosition()).getIsLiked();

                if (!is_liked) {
                    _list.get(getAdapterPosition()).setIsLiked(true);
                    likeimz.setImageResource(R.drawable.ic_baseline_favorite_fill);
                    int countlike = Integer.parseInt(likes.getText().toString()) + 1;

                    Snackbar.make(likes, "Pic liked", Snackbar.LENGTH_SHORT).show();
                    likes.setText(String.valueOf(countlike));
                    interfaceAdapterHome.likeInterface(String.valueOf(_list.get(getAdapterPosition()).getPostId()));
                    Log.e("liked", "dddd");

                } else {
                    _list.get(getAdapterPosition()).setIsLiked(false);
                    likeimz.setImageResource(R.drawable.ic_baseline_favorite_notfill);
                    int countlike = Integer.parseInt(likes.getText().toString()) - 1;
                    Snackbar.make(likes, "Pic unliked", Snackbar.LENGTH_SHORT).show();

                    likes.setText(String.valueOf(countlike));
                    Log.e("unliked", "dddd");

                }
            });

            comment.setOnClickListener(v -> {
                Intent comment = new Intent(context, ActivityComments.class);
                comment.putExtra("post_id", String.valueOf(_list.get(getAdapterPosition()).getPostId()));
                context.startActivity(comment);
            });

            userName.setOnClickListener(v ->
                    interfaceAdapterHome.callBack(_list.get(getAdapterPosition()).getUserId()));

            more.setOnClickListener(v -> {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
                View view2 = layoutInflaterAndroid.inflate(R.layout.dialog_layout, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                alertDialog.show();
                TextView delete;
                delete = view2.findViewById(R.id.delete);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("delte", "post");
                        Map<String, Object> map = new HashMap<>();
                        map.put("server_key", Constant.SERVER_KEY);
                        map.put("access_token", PrefUtils.getAccessToken());
                        map.put("post_id", _list.get(getAdapterPosition()).getPostId());
                        Log.e("delte", "post");
                        interfaceAdapterHome.deletePost(map, getAdapterPosition());
                        Log.e("delte", "postt");
                        alertDialog.dismiss();
                    }
                });
            });


            play.setOnClickListener(v -> {
//                    interfaceAdapterHome.callBackVideo(_list.get(getAdapterPosition()).getMediaSet().get(0).getFile(), getAdapterPosition());
                String url = _list.get(getAdapterPosition()).getMediaSet().get(0).getFile();
                userImage.setVisibility(View.INVISIBLE);
                videoView.setVideoPath(url);
                videoView.start();
                MediaController mediaController = new MediaController(context);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
                play.setVisibility(View.GONE);
                Log.e("fddfds", url);
            });

            videoView.setOnCompletionListener(mp -> {
                if (userImage.getVisibility() == View.INVISIBLE) {
                    videoView.setVisibility(View.GONE);
                    userImage.setVisibility(View.VISIBLE);
                    play.setVisibility(View.VISIBLE);
                }
            });
        }

    }
}


