package in.indianmeme.app.ModelApi.GetUserMsg;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("is_blocked")
	private boolean isBlocked;

	@SerializedName("messages")
	private List<MessagesItem> messages;

	@SerializedName("c_privacy")
	private boolean cPrivacy;

	@SerializedName("user_data")
	private UserData userData;

	@SerializedName("ami_blocked")
	private boolean amiBlocked;

	public void setIsBlocked(boolean isBlocked){
		this.isBlocked = isBlocked;
	}

	public boolean isIsBlocked(){
		return isBlocked;
	}

	public void setMessages(List<MessagesItem> messages){
		this.messages = messages;
	}

	public List<MessagesItem> getMessages(){
		return messages;
	}

	public void setCPrivacy(boolean cPrivacy){
		this.cPrivacy = cPrivacy;
	}

	public boolean isCPrivacy(){
		return cPrivacy;
	}

	public void setUserData(UserData userData){
		this.userData = userData;
	}

	public UserData getUserData(){
		return userData;
	}

	public void setAmiBlocked(boolean amiBlocked){
		this.amiBlocked = amiBlocked;
	}

	public boolean isAmiBlocked(){
		return amiBlocked;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"is_blocked = '" + isBlocked + '\'' + 
			",messages = '" + messages + '\'' + 
			",c_privacy = '" + cPrivacy + '\'' + 
			",user_data = '" + userData + '\'' + 
			",ami_blocked = '" + amiBlocked + '\'' + 
			"}";
		}
}