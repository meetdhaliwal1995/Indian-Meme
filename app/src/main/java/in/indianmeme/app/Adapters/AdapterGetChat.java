package in.indianmeme.app.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.indianmeme.app.Constant;
import in.indianmeme.app.ModelApi.GetUserMsg.MessagesItem;
import in.indianmeme.app.PrefUtils;
import in.indianmeme.app.R;

public class AdapterGetChat extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<MessagesItem> dataItemList;
    private final int ME = 0;
    private final int OTHER = 1;
    private InterfaceAdapterdeleteMsg interfaceAdapterdeleteMsg;

    public AdapterGetChat(Context context, List<MessagesItem> dataItemList, InterfaceAdapterdeleteMsg interfaceAdapterdeleteMsg) {
        this.context = context;
        this.dataItemList = dataItemList;
        this.interfaceAdapterdeleteMsg = interfaceAdapterdeleteMsg;
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
            String time = dataItem.getTimeText();
//            String savetime = Constant.ChangeTimeFormett(time);
            myChatViewHolder.timeMe.setText(time);

        } else {
            Log.e("user", "chat");
            OtherUserChatHolder userChatViewHolder = (OtherUserChatHolder) viewHolder;
            userChatViewHolder.userChat.setText(dataItem.getText());

            String time = dataItem.getTimeText();
//            String savetime = Constant.ChangeTimeFormett(time);
            userChatViewHolder.timeUser.setText(time);

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


    public void addMessage(List<MessagesItem> _data) {
        dataItemList.addAll(_data);
        notifyDataSetChanged();
    }

    public void addMessage(MessagesItem msg) {
        dataItemList.add(0, msg);
        notifyDataSetChanged();
    }

    public void clearMessage() {
        Log.e("beforelistSize" , String.valueOf(dataItemList.size()));

        dataItemList.clear();
        notifyDataSetChanged();
        Log.e("listSize" , String.valueOf(dataItemList.size()));
    }

    public interface InterfaceAdapterdeleteMsg {
        void onCallBackDeleteMsg(Map<String, Object> map, int pos);
    }

    public void updateList(int pos) {
        dataItemList.remove(pos);
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
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (dataItemList.get(getAdapterPosition()).getFromId() == PrefUtils.getUserId()) {
                        Log.e("btn", "true");

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
                        delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Map<String, Object> deletemsg = new HashMap<>();
                                deletemsg.put("server_key", Constant.SERVER_KEY);
                                deletemsg.put("access_token", PrefUtils.getAccessToken());
                                deletemsg.put("user_id", dataItemList.get(0).getId());
                                deletemsg.put("messages", "1");
                                interfaceAdapterdeleteMsg.onCallBackDeleteMsg(deletemsg , getAdapterPosition());
                                alertDialog.dismiss();
                            }
                        });
                    }
                    return false;
                }
            });
        }
    }
}
