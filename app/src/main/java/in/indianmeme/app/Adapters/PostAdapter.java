//package in.indianmeme.app.Adapters;
//
//public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private RealmList<ExploreData> _posts;
//    private Context mContext;
//    private OnClickerPost onClicker;
//    private int POST_VIEW = 0;
//    private int AD_VIEW = 1;
//
//    public PostAdapter(Context context, RealmList<ExploreData> _posts) {
//        this._posts = _posts;
//        this.mContext = context;
//    }
//
//    public void setOnClicker(OnClickerPost onClicker) {
//        this.onClicker = onClicker;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (viewType == POST_VIEW) {
//            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_posts, parent, false);
//            return new ItemRowHolder(v);
//        } else {
//            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_ad_explore_layout, parent, false);
//            return new AdRowHolder(v);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        ExploreData singleItem = _posts.get(i);
//
//        if (singleItem != null) {
//            onBindPost((ItemRowHolder) viewHolder, singleItem, i);
//        } else {
//            onBindAd((AdRowHolder) viewHolder);
//        }
//
//        if (i >= getItemCount() - 1 && singleItem != null) {
//            EventBus.getDefault().post(new EventUtils.Pagination(singleItem.getPostId()));
//        } else if (i >= getItemCount() - 1 && singleItem == null) {
//            ExploreData temp = _posts.get(i - 1);
//            EventBus.getDefault().post(new EventUtils.Pagination(temp.getPostId()));
//        }
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        ExploreData data = _posts.get(position);
//
//        if (data == null) {
//            return AD_VIEW;
//        }
//
//        return POST_VIEW;
//    }
//
//    @Override
//    public int getItemCount() {
//        return _posts.size();
//    }
//
//    public void updateData(RealmList<ExploreData> _posts) {
//        int loc = this._posts.size();
//
//        int looper = _posts.size() / 8;
//
//        for (int i = 0; i<looper; i++) {
//            int pos = i * 8;
//            _posts.add(pos, null);
//        }
//
//        this._posts.addAll(_posts);
//
//        notifyItemInserted(loc);
//    }
//
//    public void normalUpdateData(RealmList<ExploreData> _posts) {
//        this._posts = _posts;
//        notifyDataSetChanged();
//    }
//
//    public RealmList<ExploreData> getData() {
//        return _posts;
//    }
//
//    private void onBindPost(ItemRowHolder holder, ExploreData singleItem, int position) {
//        List<ExploreMediaSet> _Explore_mediaSet = singleItem.getMediaSet();
//
////        holder.textView.setText(singleItem.getDescription());
//
//        if (singleItem.getUserData().getAdmin() == 1) {
//            holder.adminIV.setVisibility(View.VISIBLE);
//        } else {
//            holder.adminIV.setVisibility(View.GONE);
//        }
//
//        String desc = singleItem.getDescription();
//
//        if (desc.isEmpty()) {
//            holder.postDesc.setVisibility(View.GONE);
//        } else {
//            holder.postDesc.setVisibility(View.VISIBLE);
//            holder.postDesc.setText(desc);
//        }
//
//        holder.username.setText(singleItem.getUsername());
//
//        holder.timestamp.setText(singleItem.getTimeText());
//
//        holder.like.setText(String.format("%s hearts", singleItem.getLikes()));
//
//        holder.comment.setText(String.format("%s comments", singleItem.getCommentCounts()));
//
//        Glide.with(mContext)
//                .load(singleItem.getAvatar())
//                .circleCrop()
//                .into(holder.profilePic);
//
//        if (singleItem.getIsLiked()) {
//            holder.like.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_heart_filled, 0, 0, 0);
//        } else {
//            holder.like.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_heart_holo, 0, 0, 0);
//        }
//
//        Glide.with(mContext).load(_Explore_mediaSet.get(0).getFile()).into(holder.postIV);
//
////        if (singleItem.getIsSaved()) {
////            holder.fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_bookmark_black_24dp));
////        } else {
////            holder.fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_bookmark_border_black_24dp));
////        }
//
////        if (_Explore_mediaSet.size() > 1) {
////            holder.countView.setVisibility(View.VISIBLE);
////
////            holder.countView.setText(String.format("%s/%s", 1, _Explore_mediaSet.size()));
////
////            holder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
////                @Override
////                public void onPageScrolled(int i, float v, int i1) {}
////
////                @Override
////                public void onPageSelected(int i) {
////                    holder.countView.setText(String.format("%s/%s", i + 1, _Explore_mediaSet.size()));
////                }
////
////                @Override
////                public void onPageScrollStateChanged(int i) {}
////            });
////        } else {
////            holder.countView.setVisibility(View.GONE);
////        }
//
////        holder.viewPager.setAdapter(new MyCustomViewPagerAdapter(mContext, singleItem, onClicker, position));
//    }
//
//    private void onBindAd(AdRowHolder holder) {
//        holder.itemView.setVisibility(View.INVISIBLE);
//        AdLoader adLoader = new AdLoader.Builder(mContext, mContext.getString(R.string.explore_page_native))
//                .forUnifiedNativeAd(unifiedNativeAd -> {
//                    holder.itemView.setVisibility(View.VISIBLE);
//                    holder.adHeadline.setText(unifiedNativeAd.getHeadline());
//                    holder.cta.setText(unifiedNativeAd.getCallToAction());
//                    holder.body.setText(unifiedNativeAd.getBody());
//
//                    try {
//                        Glide.with(mContext)
//                                .load(unifiedNativeAd.getIcon().getDrawable())
//                                .circleCrop()
//                                .into(holder.adIcon);
//                    } catch (Exception ignored) {}
//
//                    try {
//                        Glide.with(mContext)
//                                .load(unifiedNativeAd.getImages().get(0).getDrawable())
//                                .into(holder.imageView);
//                    } catch (Exception ignored) {}
//
//                    holder.adView.setHeadlineView(holder.adHeadline);
//                    holder.adView.setIconView(holder.adIcon);
//                    holder.adView.setCallToActionView(holder.cta);
//                    holder.adView.setBodyView(holder.body);
//                    holder.adView.setImageView(holder.imageView);
//                    holder.adView.setNativeAd(unifiedNativeAd);
//                }).build();
//
//        adLoader.loadAd(new AdRequest.Builder().build());
//    }
//
//    class ItemRowHolder extends RecyclerView.ViewHolder {
//
//        TextView postDesc, username, countView, timestamp, like, comment;
//        ImageView profilePic, more, share, fav, adminIV, postIV;
////        CustomViewPager viewPager;
//
//        ItemRowHolder(View itemView) {
//            super(itemView);
//            postDesc = itemView.findViewById(R.id.post_description);
//            adminIV = itemView.findViewById(R.id.admin_badge);
//            username = itemView.findViewById(R.id.username);
//            like = itemView.findViewById(R.id.like_count_tv);
//            countView = itemView.findViewById(R.id.count_tv);
//            postIV = itemView.findViewById(R.id.post_iv);
////            viewPager = itemView.findViewById(R.id.view_pager);
//            profilePic = itemView.findViewById(R.id.profile_pic);
//            timestamp = itemView.findViewById(R.id.timestamp_tv);
////            more = itemView.findViewById(R.id.more_btn);
//            comment = itemView.findViewById(R.id.comment_count_tv);
//            share = itemView.findViewById(R.id.share_btn);
////            fav = itemView.findViewById(R.id.fav_btn);
////            textView = itemView.findViewRByIdR(R.id.post_description);
//
//            itemView.setOnClickListener(v -> {
//                int pos = getAdapterPosition();
//
//                if (onClicker != null) {
//                    onClicker.clicked(_posts.get(pos), pos);
//                }
//            });
//
//            like.setOnClickListener(v -> {
//                int pos = getAdapterPosition();
//
//                boolean isLiked = _posts.get(pos).getIsLiked();
//
//                if (isLiked) {
//                    like.setText(String.format("%s hearts", Integer.parseInt(like.getText().toString().split(" ")[0]) - 1));
//                    like.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_heart_holo, 0, 0, 0);
//                } else {
//                    like.setText(String.format("%s hearts", Integer.parseInt(like.getText().toString().split(" ")[0]) + 1));
//                    like.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_heart_filled, 0, 0, 0);
//                }
//
//                _posts.get(pos).setIsLiked(!isLiked);
//                _posts.get(pos).setLikes(Integer.parseInt(like.getText().toString().split(" ")[0]));
//                onClicker.likeRemove(_posts.get(pos).getPostId());
//            });
//
//            share.setOnClickListener(v -> {
//                int pos = getAdapterPosition();
//
//                if (AppUtils.requestPermission((Activity) mContext, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE})) {
//                    ExploreData post = _posts.get(pos);
//
//                    Glide.with(mContext).load(post.getMediaSet().get(0).getFile())
//                            .addListener(new RequestListener<Drawable>() {
//                                @Override
//                                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                                    return false;
//                                }
//
//                                @Override
//                                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                                    String path = MediaStore.Images.Media.insertImage(mContext.getContentResolver(),
//                                            ((BitmapDrawable) resource).getBitmap(), post.getTime(), "Indian Meme");
//
//                                    Toast.makeText(mContext,
//                                            "Meme has been saved to Gallery",
//                                            Toast.LENGTH_LONG).show();
//
//                                    new Handler().postDelayed(() -> {
//                                        Intent intent = new Intent(Intent.ACTION_SEND);
//                                        intent.setType("image/*");
//                                        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
//                                        intent.putExtra(Intent.EXTRA_TEXT, mContext.getString(R.string.share_text));
//                                        mContext.startActivity(Intent.createChooser(intent, "Share Meme"));
//                                    }, 500);
//
//                                    return true;
//                                }
//                            }).preload();
//                }
//            });
//
////            fav.setOnClickListener(v -> {
////                boolean isFav = _posts.get(getAdapterPosition()).getIsSaved();
////
////                if (isFav) {
////                    fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_bookmark_border_black_24dp));
////                } else {
////                    fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_bookmark_black_24dp));
////                }
////
////                _posts.get(getAdapterPosition()).setIsLiked(!isFav);
////                onClicker.favRemove(_posts.get(getAdapterPosition()).getPostId());
////            });
//        }
//    }
//
//    class AdRowHolder extends RecyclerView.ViewHolder {
//
//        UnifiedNativeAdView adView;
//        TextView adHeadline, countView,cta, body;
//        ImageView adIcon, imageView;
//
//        AdRowHolder(View itemView) {
//            super(itemView);
//
//            adView = (UnifiedNativeAdView) itemView;
//            cta = itemView.findViewById(R.id.cta);
//            body = itemView.findViewById(R.id.body);
//            imageView = itemView.findViewById(R.id.ad_image_view);
//            adHeadline = itemView.findViewById(R.id.ad_headline);
//            countView = itemView.findViewById(R.id.count_tv);
//            adIcon = itemView.findViewById(R.id.ad_app_icon);
//        }
//    }
//}