package in.indianmeme.app.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.indianmeme.app.Constant;
import in.indianmeme.app.ModelApi.GetUserMsg.MessagesItem;
import in.indianmeme.app.PrefUtils;
import in.indianmeme.app.R;

public class AdapterGetChat extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<MessagesItem> dataItemList;
    private final int ME = 0;
    private final int OTHER = 1;

    public AdapterGetChat(Context context, List<MessagesItem> dataItemList) {
        this.context = context;
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ME) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_chat_right, parent, false);
            return new MyChatViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_chat_left, parent, false);
            return new OtherUserChatHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Log.e("size", String.valueOf(dataItemList.size()));

        MessagesItem dataItem = dataItemList.get(position);
        if (dataItem.getToId() != PrefUtils.getUserId()) {
            Log.e("my", "chat");
            MyChatViewHolder myChatViewHolder = (MyChatViewHolder) viewHolder;
            myChatViewHolder.mychat.setText(dataItem.getText());
            String time = dataItem.getTime();
            String savetime = Constant.ChangeTimeFormett(time);
            myChatViewHolder.timeMe.setText(savetime);

        } else {
            Log.e("user", "chat");
            OtherUserChatHolder userChatViewHolder = (OtherUserChatHolder) viewHolder;
            userChatViewHolder.userChat.setText(dataItem.getText());

            String time = dataItem.getTime();
            String savetime = Constant.ChangeTimeFormett(time);
            userChatViewHolder.timeUser.setText(savetime);

        }
    }

    @Override
    public int getItemViewType(int position) {
        MessagesItem dataItem = dataItemList.get(position);

        if (dataItem.getToId() != PrefUtils.getUserId()) {
            return ME;
        } else {
            return OTHER;
        }
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }


    public void addComment(List<MessagesItem> _data) {
        dataItemList.addAll(_data);
        notifyDataSetChanged();
    }

    public void addMessage(MessagesItem msg) {
        dataItemList.add(0, msg);
        notifyDataSetChanged();
    }

    public void clearComments() {
        dataItemList.clear();
        notifyDataSetChanged();
    }

    public class OtherUserChatHolder extends RecyclerView.ViewHolder {

        TextView userChat, timeUser;


        public OtherUserChatHolder(@NonNull View itemView) {
            super(itemView);
            userChat = itemView.findViewById(R.id.chat_text_user);
            timeUser = itemView.findViewById(R.id.msg_time);
        }
    }

    public class MyChatViewHolder extends RecyclerView.ViewHolder {

        TextView mychat, timeMe;

        public MyChatViewHolder(@NonNull View itemView) {
            super(itemView);
            mychat = itemView.findViewById(R.id.chat_text_me);
            timeMe = itemView.findViewById(R.id.msg_timeright);

        }
    }
}
