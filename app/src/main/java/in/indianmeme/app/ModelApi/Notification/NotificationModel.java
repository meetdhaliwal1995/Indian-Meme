package in.indianmeme.app.ModelApi.Notification;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NotificationModel {

	@SerializedName("code")
	private String code;

	@SerializedName("data")
	private List<Object> data;

	@SerializedName("new_notifications")
	private int newNotifications;

	@SerializedName("new_messages")
	private int newMessages;

	@SerializedName("status")
	private String status;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setData(List<Object> data){
		this.data = data;
	}

	public List<Object> getData(){
		return data;
	}

	public void setNewNotifications(int newNotifications){
		this.newNotifications = newNotifications;
	}

	public int getNewNotifications(){
		return newNotifications;
	}

	public void setNewMessages(int newMessages){
		this.newMessages = newMessages;
	}

	public int getNewMessages(){
		return newMessages;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"NotoficationModel{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",new_notifications = '" + newNotifications + '\'' + 
			",new_messages = '" + newMessages + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}