package in.indianmeme.app.ModelApi.GetChat;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("new_message")
	private int newMessage;

	@SerializedName("time_text")
	private String timeText;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("last_message")
	private String lastMessage;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("time")
	private String time;

	@SerializedName("id")
	private int id;

	@SerializedName("user_data")
	private UserData userData;

	@SerializedName("username")
	private String username;

	public void setNewMessage(int newMessage){
		this.newMessage = newMessage;
	}

	public int getNewMessage(){
		return newMessage;
	}

	public void setTimeText(String timeText){
		this.timeText = timeText;
	}

	public String getTimeText(){
		return timeText;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setLastMessage(String lastMessage){
		this.lastMessage = lastMessage;
	}

	public String getLastMessage(){
		return lastMessage;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUserData(UserData userData){
		this.userData = userData;
	}

	public UserData getUserData(){
		return userData;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"new_message = '" + newMessage + '\'' + 
			",time_text = '" + timeText + '\'' + 
			",user_id = '" + userId + '\'' + 
			",last_message = '" + lastMessage + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",time = '" + time + '\'' + 
			",id = '" + id + '\'' + 
			",user_data = '" + userData + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}